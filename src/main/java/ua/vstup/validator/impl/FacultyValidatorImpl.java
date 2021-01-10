package ua.vstup.validator.impl;

import ua.vstup.annotation.Validator;
import ua.vstup.domain.Faculty;
import ua.vstup.validator.FacultyValidator;

@Validator
public class FacultyValidatorImpl extends AbstractValidator implements FacultyValidator {
    @Override
    public void validate(Faculty entity) {
        validateName(entity.getName_en());
        validateName(entity.getName_ua());
        validateInteger(entity.getMaxBudgetPlace());
        validateInteger(entity.getMaxPlace());
    }
}
