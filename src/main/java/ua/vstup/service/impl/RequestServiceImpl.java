package ua.vstup.service.impl;

import ua.vstup.annotation.Autowired;
import ua.vstup.annotation.Service;
import ua.vstup.dao.EntrantDao;
import ua.vstup.dao.FacultyDao;
import ua.vstup.dao.RequestDao;
import ua.vstup.dao.SubjectDao;
import ua.vstup.domain.*;
import ua.vstup.entity.EntrantEntity;
import ua.vstup.entity.FacultyEntity;
import ua.vstup.entity.RequestEntity;
import ua.vstup.entity.RoleEntity;
import ua.vstup.exception.IncorrectDataException;
import ua.vstup.service.RequestService;
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
    private FacultyDao facultyDao;
    @Autowired
    private SubjectDao subjectDao;
    @Autowired
    private EntrantDao entrantDao;
    @Override
    public List<Request> getAllByEntrant(Entrant entrant) {
        return requestDao.findAllByEntrantId(entrant.getId()).stream()
                .map(EntityMapper::requestEntityToRequest)
                .collect(Collectors.toList());
    }

    @Override
    public List<RequestInfo> getAll() {
        List<RequestEntity> requestEntities = requestDao.findAll();
        Map<Integer, FacultyEntity> facultyEntities = facultyDao.findAll().stream()
                .collect(Collectors.toMap(FacultyEntity::getId, Function.identity()));
        Map<Integer, EntrantEntity> entrantEntities = entrantDao.findAllByRole(RoleEntity.USER).stream()
                .collect(Collectors.toMap(EntrantEntity::getId, Function.identity()));

        return requestEntities.stream().map(requestEntity ->
                RequestInfo.builder()
                        .withId(requestEntity.getId())
                        .withEntrantName(entrantEntities.get(requestEntity.getEntrantEntityId()).getName())
                        .withFacultyNameEn(facultyEntities.get(requestEntity.getFacultyEntityId()).getName_en())
                        .withFacultyNameUa(facultyEntities.get(requestEntity.getFacultyEntityId()).getName_ua())
                        .withFirstSubject(EntityMapper.subjectEntityToSubject(subjectDao.findById(requestEntity.getFirstSubjectEntityId()).get()))
                        .withSecondSubject(EntityMapper.subjectEntityToSubject(subjectDao.findById(requestEntity.getSecondSubjectEntityId()).get()))
                        .withThirdSubject(EntityMapper.subjectEntityToSubject(subjectDao.findById(requestEntity.getThirdSubjectEntityId()).get()))
                        .withState(State.valueOf(requestEntity.getStateEntity().name()))
                        .build()
        ).collect(Collectors.toList());
    }

    @Override
    public List<RequestInfo> getAllInfoByEntrant(Entrant entrant) {
        List<RequestEntity> requestEntities = requestDao.findAllByEntrantId(entrant.getId());
        Map<Integer, FacultyEntity> facultyEntities = facultyDao.findAll().stream()
                .collect(Collectors.toMap(FacultyEntity::getId, Function.identity()));

        return requestEntities.stream().map(requestEntity ->
            RequestInfo.builder()
                    .withId(requestEntity.getId())
                    .withEntrantName(entrant.getName())
                    .withFacultyNameEn(facultyEntities.get(requestEntity.getFacultyEntityId()).getName_en())
                    .withFacultyNameUa(facultyEntities.get(requestEntity.getFacultyEntityId()).getName_ua())
                    .withFirstSubject(EntityMapper.subjectEntityToSubject(subjectDao.findById(requestEntity.getFirstSubjectEntityId()).get()))
                    .withSecondSubject(EntityMapper.subjectEntityToSubject(subjectDao.findById(requestEntity.getSecondSubjectEntityId()).get()))
                    .withThirdSubject(EntityMapper.subjectEntityToSubject(subjectDao.findById(requestEntity.getThirdSubjectEntityId()).get()))
                    .withState(State.valueOf(requestEntity.getStateEntity().name()))
                    .build()
        ).collect(Collectors.toList());
    }

    private <T> T fromOptional(Optional<T> optional){
        return optional.orElseThrow(() -> new IncorrectDataException("Record not found"));
    }

}
