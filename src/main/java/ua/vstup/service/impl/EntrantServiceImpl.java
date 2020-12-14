package ua.vstup.service.impl;

import ua.vstup.annotation.Autowired;
import ua.vstup.annotation.Service;
import ua.vstup.dao.EntrantDao;
import ua.vstup.dao.RequirementDao;
import ua.vstup.dao.SubjectDao;
import ua.vstup.domain.Entrant;
import ua.vstup.domain.EntrantInfo;
import ua.vstup.domain.Requirement;
import ua.vstup.domain.Subject;
import ua.vstup.entity.EntrantEntity;
import ua.vstup.exception.IncorrectDataException;
import ua.vstup.service.EntrantService;
import ua.vstup.service.utility.EntityMapper;
import ua.vstup.validator.EntrantValidator;
import ua.vstup.validator.RequirementValidator;
import ua.vstup.validator.SubjectValidator;

import javax.print.attribute.standard.RequestingUserName;
import java.util.List;
import java.util.Optional;

@Service
public class EntrantServiceImpl implements EntrantService {
    @Autowired
    private EntrantDao entrantDao;
    @Autowired
    private SubjectDao subjectDao;
    @Autowired
    private RequirementDao requirementDao;

    @Autowired
    private EntrantValidator entrantValidator;
    @Autowired
    private SubjectValidator subjectValidator;
    @Autowired
    private RequirementValidator requirementValidator;

    @Override
    public Entrant login(String email, String password) {
        Optional<EntrantEntity> entrantByEmail = entrantDao.findByEmail(email);
        if(entrantByEmail.isPresent() && entrantByEmail.get().getPassword().equals(password)){
            return EntityMapper.entrantEntityToEntrant(entrantByEmail.get());
        }
        return null;
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
                .withFourthSubjectId(subjectDao.save(EntityMapper.subjectToSubjectEntity(subjectList.get(3))))
                .withFifthSubjectId(subjectDao.save(EntityMapper.subjectToSubjectEntity(subjectList.get(4))))
                .build();

        requirementValidator.validate(requirement);

        entrant.setRequirementId(requirementDao.save(EntityMapper.requirementToRequirementEntity(requirement)));
        entrantDao.save(EntityMapper.entrantToEntrantEntity(entrant));
    }

    @Override
    public void edit(Entrant entrant) {

    }

    @Override
    public EntrantInfo getEntrantInfo(Entrant entrant) {

        return null;
    }
}