package ua.vstup.validator.impl;

import ua.vstup.annotation.Validator;
import ua.vstup.domain.Subject;
import ua.vstup.exception.ValidationException;
import ua.vstup.validator.SubjectValidator;

@Validator
public class SubjectValidatorImpl extends AbstractValidator implements SubjectValidator {
    private static final Integer MIN_RATE = 100;
    private static final Integer MAX_RATE = 200;
    @Override
    public void validateRate(Integer rate) {
        if(rate < MIN_RATE || rate > MAX_RATE){
            throw new ValidationException("rate.must.be.in.range(100,200)");
        }
    }

    @Override
    public void validate(Subject entity) {
        validateRate(entity.getRate());
    }
}
