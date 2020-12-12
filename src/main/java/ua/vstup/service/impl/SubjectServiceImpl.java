package ua.vstup.service.impl;

import ua.vstup.annotation.Autowired;
import ua.vstup.annotation.Service;
import ua.vstup.dao.SubjectDao;
import ua.vstup.domain.Subject;
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
    public Integer add(Subject subject) {
        subjectValidator.validate(subject);
        return subjectDao.save(EntityMapper.subjectToSubjectEntity(subject));
    }
}
