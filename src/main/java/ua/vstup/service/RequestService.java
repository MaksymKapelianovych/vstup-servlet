package ua.vstup.service;

import ua.vstup.annotation.Service;
import ua.vstup.annotation.Transactional;
import ua.vstup.domain.Entrant;
import ua.vstup.domain.Request;
import ua.vstup.domain.RequestInfo;
import ua.vstup.domain.RequestInfoForEntrant;

import java.util.List;

public interface RequestService {
    List<Request> getAllByEntrant(Entrant entrant);

    @Transactional
    List<RequestInfo> getAllInfoByEntrant(Entrant entrant);

    List<RequestInfo> getAll();
}
