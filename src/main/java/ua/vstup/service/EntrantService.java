package ua.vstup.service;

import ua.vstup.annotation.Transactional;
import ua.vstup.domain.Entrant;
import ua.vstup.domain.Requirement;
import ua.vstup.domain.Subject;

import java.util.List;

public interface EntrantService {
    Entrant login(String email, String password);

    @Transactional
    void register(Entrant entrant, List<Subject> subjectList);

    void edit(Entrant entrant);
}
