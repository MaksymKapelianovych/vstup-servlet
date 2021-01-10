package ua.vstup.service.impl;

import ua.vstup.annotation.Autowired;
import ua.vstup.annotation.Service;
import ua.vstup.dao.FacultyDao;
import ua.vstup.dao.RequestDao;
import ua.vstup.dao.StatementDao;
import ua.vstup.domain.*;
import ua.vstup.entity.StatementEntity;
import ua.vstup.exception.IncorrectDataException;
import ua.vstup.service.FacultyService;
import ua.vstup.service.RequestService;
import ua.vstup.service.StatementService;
import ua.vstup.service.utility.EntityMapper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatementServiceImpl implements StatementService {
    @Autowired
    private StatementDao statementDao;
    @Autowired
    private RequestDao requestDao;
    @Autowired
    private FacultyDao facultyDao;

    @Autowired
    private RequestService requestService;
    @Autowired
    private FacultyService facultyService;

    @Override
    public void createStatement() {
        if(statementDao.findByFinalized(false).isPresent()){
            throw new IncorrectDataException("Statement already exists");
        }

        Statement statement = new Statement(null, false);
        if(statementDao.save(EntityMapper.statementEntityFromStatement(statement)) == 0){
            throw new IncorrectDataException("Incorrect data");
        }
    }

    @Override
    public Statement getUnfinalizedStatement() {
        StatementEntity statementEntity = statementDao.findByFinalized(false)
                .orElse(null);
        return EntityMapper.statementFromStatementEntity(statementEntity);
    }

    @Override
    public void finalizeStatement() {
        StatementEntity statementEntity = statementDao.findByFinalized(false)
                .orElse(null);
        if(statementEntity == null){
            throw new IncorrectDataException("Statement don`t exists");
        }

        List<FacultyInfo> facultyList = facultyDao.findAllByActive(true).stream()
                .map(facultyEntity -> facultyService.getFacultyInfo(facultyEntity.getId()))
                .collect(Collectors.toList());

        List<RequestInfo> requestList = requestService.getAllInfoByStatementId(statementEntity.getId()).stream()
                .peek(request -> request.setFaculty(facultyList.stream()
                        .filter(faculty -> faculty.equals(request.getFaculty()))
                        .findAny().orElseThrow(() -> new IncorrectDataException(""))))
                .collect(Collectors.toList());

        List<EntrantInfo> passedEntrants = new ArrayList<>();

        while(facultyList.stream().anyMatch(faculty -> faculty.getMaxBudgetPlace() > 0 &&
                requestList.stream().anyMatch(request ->
                        request.getState() == State.ACCEPTED &&
                                request.getFaculty().equals(faculty) &&
                                !passedEntrants.contains(request.getEntrant())))) {
            facultyList.forEach(faculty -> processRequestToBudget(requestList, faculty, passedEntrants));
        }

        while(facultyList.stream().anyMatch(faculty -> faculty.getMaxPlace() > 0 &&
                requestList.stream().anyMatch(request ->
                        request.getState() == State.ACCEPTED &&
                                request.getFaculty().equals(faculty) &&
                                !passedEntrants.contains(request.getEntrant())))) {
            facultyList.forEach(faculty -> processRequestToContract(requestList, faculty, passedEntrants));
        }

        processRequestToNotPass(requestList);

        requestList.forEach(request -> requestDao.save(EntityMapper.requestInfoToRequestEntity(request)));
        statementEntity.setFinalized(true);
        statementDao.save(statementEntity);
    }

    private void processRequestToNotPass(List<RequestInfo> requestList) {
        requestList.stream()
                .filter(request -> request.getState() == State.ACCEPTED)
                .forEach(request -> request.setState(State.NOT_PASS));
    }

    private void processRequestToContract(List<RequestInfo> requestList, FacultyInfo faculty, List<EntrantInfo> passedEntrants) {
        requestList.stream()
                .filter(request -> request.getFaculty().equals(faculty) &&
                        !passedEntrants.contains(request.getEntrant()) &&
                        !requestWithHigherPriorityCanPassContract(requestList, request)
                )
                .sorted(Comparator.comparing(RequestInfo::getRate))
                .limit(faculty.getMaxPlace())
                .peek(System.out::println)
                .forEach(request -> {
                    request.setState(State.CONTRACT);
                    passedEntrants.add(request.getEntrant());
                    faculty.decreasePlace();
                });
    }

    private void processRequestToBudget(List<RequestInfo> requestList, FacultyInfo faculty, List<EntrantInfo> passedEntrants){
        requestList.stream()
                .filter(request -> request.getFaculty().equals(faculty) &&
                        !passedEntrants.contains(request.getEntrant()) &&
                        !requestWithHigherPriorityCanPassBudget(requestList, request)
                )
                .sorted(Comparator.comparing(RequestInfo::getRate))
                .limit(faculty.getMaxBudgetPlace())
                .peek(System.out::println)
                .forEach(request -> {
                    request.setState(State.BUDGET);
                    passedEntrants.add(request.getEntrant());
                    faculty.decreaseBudgetPlace();
                });
    }

    private boolean requestWithHigherPriorityCanPassBudget(List<RequestInfo> requestList, RequestInfo goalRequest){
        return requestList.stream().anyMatch(request -> request != goalRequest &&
                request.getFaculty().getMaxBudgetPlace() > 0 &&
                request.getPriority() < goalRequest.getPriority() &&
                request.getEntrant().equals(goalRequest.getEntrant()) &&
                request.getState() != State.ACTIVE);
    }

    private boolean requestWithHigherPriorityCanPassContract(List<RequestInfo> requestList, RequestInfo goalRequest){
        return requestList.stream().anyMatch(request -> request != goalRequest &&
                request.getFaculty().getMaxPlace() > 0 &&
                request.getPriority() < goalRequest.getPriority() &&
                request.getEntrant().equals(goalRequest.getEntrant()) &&
                request.getState() != State.ACTIVE);
    }
}
