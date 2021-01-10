package ua.vstup.service.impl;

import ua.vstup.annotation.Autowired;
import ua.vstup.annotation.Service;
import ua.vstup.dao.EntrantDao;
import ua.vstup.dao.RequirementDao;
import ua.vstup.dao.SchoolDao;
import ua.vstup.dao.SubjectDao;
import ua.vstup.domain.*;
import ua.vstup.entity.*;
import ua.vstup.exception.IncorrectDataException;
import ua.vstup.service.EntrantService;
import ua.vstup.service.utility.EntityMapper;
import ua.vstup.validator.EntrantValidator;
import ua.vstup.validator.RequirementValidator;
import ua.vstup.validator.SubjectValidator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntrantServiceImpl implements EntrantService {
    @Autowired
    private EntrantDao entrantDao;
    @Autowired
    private SubjectDao subjectDao;
    @Autowired
    private RequirementDao requirementDao;
    @Autowired
    private SchoolDao schoolDao;

    @Autowired
    private EntrantValidator entrantValidator;
    @Autowired
    private SubjectValidator subjectValidator;
    @Autowired
    private RequirementValidator requirementValidator;

    @Override
    public EntrantInfo login(String email, String password) {
        EntrantEntity entrantByEmail = entrantDao.findByEmail(email)
                .orElseThrow(() -> new IncorrectDataException("Entrant not found"));

        Entrant entrant = EntityMapper.entrantEntityToEntrant(entrantByEmail);

        if(entrant.getActive()) {
            if (entrant.getPassword().equals(password)) {
                return getEntrantInfo(entrant);
            }
        }
        return null;
//        }else{
//            throw new IncorrectDataException("Entrant disabled");
//        }
    }

    @Override
    public void register(Entrant entrant, List<Subject> subjectList) {
        entrantValidator.validate(entrant);
        if(entrantDao.findByEmail(entrant.getEmail()).isPresent()){
            throw new IncorrectDataException("entrant.already.exists");
        }

        subjectValidator.validate(subjectList);

        Requirement requirement = Requirement.builder()
                .withFirstSubjectId(subjectDao.save(EntityMapper.subjectToSubjectEntity(subjectList.get(0))))
                .withSecondSubjectId(subjectDao.save(EntityMapper.subjectToSubjectEntity(subjectList.get(1))))
                .withThirdSubjectId(subjectDao.save(EntityMapper.subjectToSubjectEntity(subjectList.get(2))))
                .build();

        requirementValidator.validate(requirement);

        entrant.setRequirementId(requirementDao.save(EntityMapper.requirementToRequirementEntity(requirement)));
        if(entrantDao.save(EntityMapper.entrantToEntrantEntity(entrant)) == 0){
            throw new IncorrectDataException("Incorrect data");
        }
    }

    @Override
    public void edit(Entrant entrant) {

    }

    @Override
    public EntrantInfo getEntrantInfo(Entrant entrant) {
        SchoolEntity schoolEntity = schoolDao.findById(entrant.getSchoolId())
                .orElseThrow(() -> new IncorrectDataException("School not found"));
        RequirementEntity requirementEntity = requirementDao.findById(entrant.getRequirementId())
                .orElseThrow(() -> new IncorrectDataException("Requirement not found"));
        SubjectEntity subjectEntity1 = subjectDao.findById(requirementEntity.getFirstSubjectId())
                .orElseThrow(() -> new IncorrectDataException("Subject not found"));
        SubjectEntity subjectEntity2 = subjectDao.findById(requirementEntity.getSecondSubjectId())
                .orElseThrow(() -> new IncorrectDataException("Subject not found"));
        SubjectEntity subjectEntity3 = subjectDao.findById(requirementEntity.getThirdSubjectId())
                .orElseThrow(() -> new IncorrectDataException("Subject not found"));

        School school = EntityMapper.schoolEntityToSchool(schoolEntity);
        RequirementInfo requirementInfo = EntityMapper.subjectEntityListToRequirementInfo(
                subjectEntity1, subjectEntity2, subjectEntity3);

        return EntrantInfo.builder()
                .withId(entrant.getId())
                .withName(entrant.getName())
                .withEmail(entrant.getEmail())
                .withSchool(school)
                .withRole(entrant.getRole())
                .withRequirementInfo(requirementInfo)
                .build();
    }

    @Override
    public List<Entrant> getAllEntrants() {
        return entrantDao.findAllByRole(RoleEntity.USER).stream()
                .map(EntityMapper::entrantEntityToEntrant)
                .collect(Collectors.toList());
    }

    @Override
    public void disable(Integer id) {
        entrantDao.updateActiveById(id, false);
    }

    @Override
    public void enable(Integer id) {
        entrantDao.updateActiveById(id, true);
    }
}