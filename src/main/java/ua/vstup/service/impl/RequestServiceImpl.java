package ua.vstup.service.impl;

import com.sun.istack.internal.NotNull;
import ua.vstup.annotation.Autowired;
import ua.vstup.annotation.Service;
import ua.vstup.dao.EntrantDao;
import ua.vstup.dao.FacultyDao;
import ua.vstup.dao.RequestDao;
import ua.vstup.dao.SubjectDao;
import ua.vstup.domain.*;
import ua.vstup.entity.*;
import ua.vstup.exception.IncorrectDataException;
import ua.vstup.service.EntrantService;
import ua.vstup.service.FacultyService;
import ua.vstup.service.RequestService;
import ua.vstup.service.SubjectService;
import ua.vstup.service.utility.EntityMapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestDao requestDao;

    @Autowired
    private FacultyService facultyService;
    @Autowired
    private EntrantService entrantService;
    @Autowired
    private SubjectService subjectService;

    @Override
    public List<Request> getAllByEntrant(Entrant entrant) {
        return requestDao.findAllByEntrantId(entrant.getId()).stream()
                .map(EntityMapper::requestEntityToRequest)
                .collect(Collectors.toList());
    }

    @Override
    public List<RequestInfo> getAll() {
        List<RequestEntity> requestEntities = requestDao.findAll();
        return getInfoByRequestEntity(requestEntities);
    }

    @Override
    public List<RequestInfo> getAllInfoByStatementId(Integer id) {
        List<RequestEntity> requestEntities = requestDao.findAllByStatementId(id);
        return getInfoByRequestEntity(requestEntities);
    }

    @Override
    public void updateStateById(Integer id,State state) {
        if(!requestDao.updateStateById(id, StateEntity.valueOf(state.name()))){
            throw new IncorrectDataException("");
        }
    }

    @Override
    public void add(Request entrantRequest) {
        Optional<RequestEntity> requestEntity = requestDao.findByEntrantIdAndFacultyId(entrantRequest.getEntrantId(), entrantRequest.getFacultyId());
        if(requestEntity.isPresent()){
            throw new IncorrectDataException("Request to this faculty already exist");
        }
        if(requestDao.save(EntityMapper.requestToRequestEntity(entrantRequest)) == 0){
            throw new IncorrectDataException("Incorrect data");
        }
    }

    @Override
    public List<RequestInfo> getAllInfoByEntrant(EntrantInfo entrant) {
        List<RequestEntity> requestEntities = requestDao.findAllByEntrantId(entrant.getId());
        return getInfoByRequestEntity(requestEntities);
    }

    private List<RequestInfo> getInfoByRequestEntity(List<RequestEntity> requestEntities){
        Map<Integer, Faculty> facultyEntities = facultyService.getAllActive().stream()
                .collect(Collectors.toMap(Faculty::getId, Function.identity()));
        Map<Integer, EntrantInfo> entrantInfoMap = entrantService.getAllEntrants().stream()
                .map(entrant -> entrantService.getEntrantInfo(entrant))
                .collect(Collectors.toMap(EntrantInfo::getId, Function.identity()));


        return requestEntities.stream().map(requestEntity ->
                RequestInfo.builder()
                        .withId(requestEntity.getId())
                        .withEntrant(entrantInfoMap.get(requestEntity.getEntrantEntityId()))
                        .withFaculty(facultyEntities.get(requestEntity.getFacultyEntityId()))
                        .withFirstSubject(subjectService.getById(requestEntity.getFirstSubjectEntityId()))
                        .withSecondSubject(subjectService.getById(requestEntity.getSecondSubjectEntityId()))
                        .withThirdSubject(subjectService.getById(requestEntity.getThirdSubjectEntityId()))
                        .withState(State.valueOf(requestEntity.getStateEntity().name()))
                        .withPriority(requestEntity.getPriority())
                        .build()
        ).collect(Collectors.toList());
    }

}
