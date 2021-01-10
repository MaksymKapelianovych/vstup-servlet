package ua.vstup.validator.impl;

import ua.vstup.annotation.Autowired;
import ua.vstup.domain.RequestInfo;
import ua.vstup.exception.ValidationException;
import ua.vstup.validator.RequestInfoValidator;
import ua.vstup.validator.SubjectValidator;

public class RequestInfoValidatorImpl extends AbstractValidator implements RequestInfoValidator {
    @Autowired
    private SubjectValidator subjectValidator;
    @Override
    public void validate(RequestInfo entity) {
        subjectValidator.validate(entity.getFirstSubject());
        subjectValidator.validate(entity.getSecondSubject());
        subjectValidator.validate(entity.getThirdSubject());
    }
}
