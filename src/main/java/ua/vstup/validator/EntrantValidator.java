package ua.vstup.validator;

import ua.vstup.domain.Entrant;

public interface EntrantValidator extends Validator<Entrant>{
    void validatePassword(String password);
    void validateEmail(String email);
}
