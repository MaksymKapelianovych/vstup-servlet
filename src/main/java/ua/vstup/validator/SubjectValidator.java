package ua.vstup.validator;

import ua.vstup.domain.Subject;

import java.util.List;

public interface SubjectValidator extends Validator<Subject> {
    void validateRate(Integer rate);
    void validate(List<Subject> subjectList);
}
