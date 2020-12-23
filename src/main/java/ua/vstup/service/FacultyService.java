package ua.vstup.service;

import ua.vstup.annotation.Transactional;
import ua.vstup.domain.Faculty;
import ua.vstup.domain.FacultyInfo;
import ua.vstup.domain.Subject;

import java.util.List;

public interface FacultyService {
    List<Faculty> getAll();

    @Transactional
    void add(Faculty faculty, List<Subject> subjectList);

    Faculty findById(Integer valueOf);

    @Transactional
    FacultyInfo getFacultyInto(Faculty faculty);

    void delete(Integer id);
}

