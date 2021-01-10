package ua.vstup.service;

import ua.vstup.domain.Subject;

import java.util.List;

public interface SubjectService {
    void add(Subject subject);

    Subject getById(Integer id);
}
