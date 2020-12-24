package ua.vstup.service.impl;

import ua.vstup.annotation.Autowired;
import ua.vstup.annotation.Service;
import ua.vstup.dao.EntrantDao;
import ua.vstup.dao.FacultyDao;
import ua.vstup.dao.RequirementDao;
import ua.vstup.dao.SubjectDao;
import ua.vstup.domain.*;
import ua.vstup.entity.FacultyEntity;
import ua.vstup.entity.RequirementEntity;
import ua.vstup.entity.SubjectEntity;
import ua.vstup.exception.IncorrectDataException;
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
        return facultyDao.findAll().stream()
                .map(EntityMapper::facultyEntityToFaculty)
                .collect(Collectors.toList());
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

    @Override
    public FacultyInfo getFacultyInto(Integer id) {
        FacultyEntity facultyEntity = facultyDao.findById(id)
                .orElseThrow(() -> new IncorrectDataException("Faculty not found"));

        RequirementEntity requirementEntity = requirementDao.findById(facultyEntity.getRequirementEntityId())
                .orElseThrow(() -> new IncorrectDataException("Requirement not found"));
        SubjectEntity subjectEntity1 = subjectDao.findById(requirementEntity.getFirstSubjectId())
                .orElseThrow(() -> new IncorrectDataException("Subject not found"));
        SubjectEntity subjectEntity2 = subjectDao.findById(requirementEntity.getSecondSubjectId())
                .orElseThrow(() -> new IncorrectDataException("Subject not found"));
        SubjectEntity subjectEntity3 = subjectDao.findById(requirementEntity.getThirdSubjectId())
                .orElseThrow(() -> new IncorrectDataException("Subject not found"));
        SubjectEntity subjectEntity4 = subjectDao.findById(requirementEntity.getFourthSubjectId())
                .orElse(null);
        SubjectEntity subjectEntity5 = subjectDao.findById(requirementEntity.getFifthSubjectId())
                .orElse(null);

        RequirementInfo requirementInfo = EntityMapper.subjectEntityListToRequirementInfo(
                subjectEntity1, subjectEntity2, subjectEntity3, subjectEntity4, subjectEntity5);


        return FacultyInfo.builder()
                .withId(facultyEntity.getId())
                .withNameEn(facultyEntity.getName_en())
                .withNameEn(facultyEntity.getName_en())
                .withNameUa(facultyEntity.getName_ua())
                .withMaxBudgetPlace(facultyEntity.getMaxBudgetPlace())
                .withMaxPlace(facultyEntity.getMaxPlace())
                .withRequirementInfo(requirementInfo)
                .build();
    }

    @Override
    public void delete(Integer id) {
        facultyDao.updateActiveById(id, false);

    }

    @Override
    public List<Faculty> getAllActive() {
        return facultyDao.findAllByActive(true).stream()
                .map(EntityMapper::facultyEntityToFaculty)
                .collect(Collectors.toList());
    }
}
