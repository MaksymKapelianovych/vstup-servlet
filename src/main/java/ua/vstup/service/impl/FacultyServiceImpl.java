package ua.vstup.service.impl;

import ua.vstup.annotation.Autowired;
import ua.vstup.annotation.Service;
import ua.vstup.dao.EntrantDao;
import ua.vstup.dao.FacultyDao;
import ua.vstup.dao.RequirementDao;
import ua.vstup.dao.SubjectDao;
import ua.vstup.domain.Faculty;
import ua.vstup.domain.Requirement;
import ua.vstup.domain.Subject;
import ua.vstup.service.FacultyService;
import ua.vstup.service.utility.EntityMapper;
import ua.vstup.validator.EntrantValidator;
import ua.vstup.validator.FacultyValidator;
import ua.vstup.validator.RequirementValidator;
import ua.vstup.validator.SubjectValidator;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    private FacultyDao facultyDao;
    @Autowired
    private SubjectDao subjectDao;
    @Autowired
    private RequirementDao requirementDao;

    @Autowired
    private FacultyValidator facultyValidator;
    @Autowired
    private SubjectValidator subjectValidator;
    @Autowired
    private RequirementValidator requirementValidator;

    @Override
    public List<Faculty> getAll() {
        return facultyDao.findAll().stream().map(EntityMapper::facultyEntityToFaculty).collect(Collectors.toList());
    }

    @Override
    public void add(Faculty faculty, List<Subject> subjectList) {
        //facultyValidator.validate(faculty);
        //subjectValidator.validate(subjectList);

        Requirement requirement = Requirement.builder()
                .withFirstSubjectId(subjectDao.save(EntityMapper.subjectToSubjectEntity(subjectList.get(0))))
                .withSecondSubjectId(subjectDao.save(EntityMapper.subjectToSubjectEntity(subjectList.get(1))))
                .withThirdSubjectId(subjectDao.save(EntityMapper.subjectToSubjectEntity(subjectList.get(2))))
                .withFourthSubjectId(subjectDao.save(EntityMapper.subjectToSubjectEntity(subjectList.get(3))))
                .withFifthSubjectId(subjectDao.save(EntityMapper.subjectToSubjectEntity(subjectList.get(4))))
                .build();

        requirementValidator.validate(requirement);

        faculty.setRequirementId(requirementDao.save(EntityMapper.requirementToRequirementEntity(requirement)));
        facultyDao.save(EntityMapper.facultyToFacultyEntity(faculty));
    }
}