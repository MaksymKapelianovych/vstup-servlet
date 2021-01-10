package ua.vstup.service.impl;

import ua.vstup.annotation.Autowired;
import ua.vstup.annotation.Service;
import ua.vstup.dao.SubjectDao;
import ua.vstup.domain.Subject;
import ua.vstup.exception.IncorrectDataException;
import ua.vstup.service.SubjectService;
import ua.vstup.service.utility.EntityMapper;
import ua.vstup.validator.SubjectValidator;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectDao subjectDao;
    @Autowired
    private SubjectValidator subjectValidator;

    @Override
    public void add(Subject subject) {
        subjectValidator.validate(subject);
        if(subjectDao.save(EntityMapper.subjectToSubjectEntity(subject)) == 0){
            throw new IncorrectDataException("Incorrect data");
        }
    }

    @Override
    public Subject getById(Integer id) {
        return EntityMapper.subjectEntityToSubject(subjectDao.findById(id)
                .orElseThrow(() -> new IncorrectDataException("Subject not exists")));
    }
}
