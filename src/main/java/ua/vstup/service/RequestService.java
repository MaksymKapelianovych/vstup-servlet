package ua.vstup.service;

import ua.vstup.annotation.Transactional;
import ua.vstup.domain.*;

import java.util.List;

public interface RequestService {
    List<Request> getAllByEntrant(Entrant entrant);

    @Transactional
    List<RequestInfo> getAllInfoByEntrant(EntrantInfo entrant);
    @Transactional
    List<RequestInfo> getAll();
    @Transactional
    List<RequestInfo> getAllInfoByStatementId(Integer id);

    void updateStateById(Integer id, State state);

    @Transactional
    void add(Request entrantRequest);

    List<Subject> jointSubjects(RequirementInfo facultyInfo, RequirementInfo entrantInfo);
}
