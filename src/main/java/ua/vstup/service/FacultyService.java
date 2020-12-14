package ua.vstup.service;

import ua.vstup.annotation.Transactional;
import ua.vstup.domain.Faculty;
import ua.vstup.domain.Subject;

import java.util.List;

public interface FacultyService {
    List<Faculty> getAll();

    @Transactional
    void add(Faculty faculty, List<Subject> subjectList);
}
