package ua.vstup.service;

import ua.vstup.domain.Entrant;

public interface EntrantService {
    Entrant login(String email, String password);

    void register(Entrant entrant);

    void edit(Entrant entrant);
}
