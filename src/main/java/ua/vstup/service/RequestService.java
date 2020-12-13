package ua.vstup.service;

import ua.vstup.annotation.Service;
import ua.vstup.domain.Entrant;
import ua.vstup.domain.Request;

import java.util.List;

public interface RequestService {
    List<Request> getAll(Entrant entrant);
}
