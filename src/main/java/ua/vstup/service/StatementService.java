package ua.vstup.service;

import ua.vstup.annotation.Transactional;
import ua.vstup.domain.Statement;

public interface StatementService {
    @Transactional
    void createStatement();

    Statement getUnfinalizedStatement();

    @Transactional
    void finalizeStatement();
}
