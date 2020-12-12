package ua.vstup.validator.impl;

import ua.vstup.annotation.Validator;
import ua.vstup.domain.Requirement;
import ua.vstup.domain.SubjectName;
import ua.vstup.validator.RequirementValidator;

import java.util.ArrayList;
import java.util.List;

@Validator
public class RequirementValidatorImpl extends AbstractValidator implements RequirementValidator {
    @Override
    public void validate(Requirement entity) {
    }

}
