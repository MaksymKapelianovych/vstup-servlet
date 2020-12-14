package ua.vstup.service.impl;

import ua.vstup.annotation.Autowired;
import ua.vstup.annotation.Service;
import ua.vstup.dao.FacultyDao;
import ua.vstup.domain.Faculty;
import ua.vstup.service.FacultyService;
import ua.vstup.service.utility.EntityMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    private FacultyDao facultyDao;

    @Override
    public List<Faculty> getAll() {
        return facultyDao.findAll().stream().map(EntityMapper::facultyEntityToFaculty).collect(Collectors.toList());
    }
}
