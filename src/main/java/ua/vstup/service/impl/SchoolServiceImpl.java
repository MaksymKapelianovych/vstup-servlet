package ua.vstup.service.impl;

import ua.vstup.annotation.Autowired;
import ua.vstup.annotation.Service;
import ua.vstup.dao.SchoolDao;
import ua.vstup.domain.School;
import ua.vstup.entity.SchoolEntity;
import ua.vstup.exception.IncorrectDataException;
import ua.vstup.service.SchoolService;
import ua.vstup.service.utility.EntityMapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolDao schoolDao;

    @Override
    public void add(School school) {

        if(schoolDao.save(EntityMapper.schoolToSchoolEntity(school)) == 0){
            throw new IncorrectDataException("Incorrect data");
        }
    }

    @Override
    public List<School> getAll() {
        return schoolDao.findAll().stream().map(EntityMapper::schoolEntityToSchool).collect(Collectors.toList());
    }
}
