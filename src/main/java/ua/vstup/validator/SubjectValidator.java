package ua.vstup.validator;

import ua.vstup.domain.Subject;

public interface SubjectValidator extends Validator<Subject> {
    void validateRate(Integer rate);
}
