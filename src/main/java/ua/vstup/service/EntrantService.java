package ua.vstup.service;

import ua.vstup.annotation.Transactional;
import ua.vstup.domain.Entrant;
import ua.vstup.domain.EntrantInfo;
import ua.vstup.domain.Requirement;
import ua.vstup.domain.Subject;

import java.util.List;

public interface EntrantService {
    EntrantInfo login(String email, String password);

    @Transactional
    void register(Entrant entrant, List<Subject> subjectList);

    void edit(Entrant entrant);

    @Transactional
    EntrantInfo getEntrantInfo(Entrant entrant);

    List<Entrant> getAllEntrants();

    void disable(Integer id);
    void enable(Integer id);
}
