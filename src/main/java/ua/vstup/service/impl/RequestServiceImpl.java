package ua.vstup.service.impl;

import ua.vstup.annotation.Autowired;
import ua.vstup.annotation.Service;
import ua.vstup.dao.FacultyDao;
import ua.vstup.dao.RequestDao;
import ua.vstup.dao.SubjectDao;
import ua.vstup.domain.*;
import ua.vstup.entity.FacultyEntity;
import ua.vstup.entity.RequestEntity;
import ua.vstup.service.RequestService;
import ua.vstup.service.utility.EntityMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestDao requestDao;
    @Autowired
    private FacultyDao facultyDao;
    @Autowired
    private SubjectDao subjectDao;
    @Override
    public List<Request> getAll(Entrant entrant) {
        return requestDao.findAllByEntrantId(entrant.getId()).stream()
                .map(EntityMapper::requestEntityToRequest)
                .collect(Collectors.toList());
    }

    @Override
    public List<RequestInfoForEntrant> getAllInfoByEntrant(Entrant entrant) {
        List<RequestEntity> requestEntities = requestDao.findAllByEntrantId(entrant.getId());

        return requestEntities.stream().map(requestEntity ->
            RequestInfoForEntrant.builder()
                    .withFaculty(EntityMapper.facultyEntityToFaculty(facultyDao.findById(requestEntity.getFacultyEntityId()).get()))
                    .withFirstSubject(EntityMapper.subjectEntityToSubject(subjectDao.findById(requestEntity.getFirstSubjectEntityId()).get()))
                    .withSecondSubject(EntityMapper.subjectEntityToSubject(subjectDao.findById(requestEntity.getSecondSubjectEntityId()).get()))
                    .withThirdSubject(EntityMapper.subjectEntityToSubject(subjectDao.findById(requestEntity.getThirdSubjectEntityId()).get()))
                    .withState(State.valueOf(requestEntity.getStateEntity().name()))
                    .build()
        ).collect(Collectors.toList());
    }
}
