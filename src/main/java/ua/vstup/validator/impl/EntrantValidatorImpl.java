package ua.vstup.validator.impl;

import ua.vstup.annotation.Validator;
import ua.vstup.domain.Entrant;
import ua.vstup.exception.ValidationException;
import ua.vstup.validator.EntrantValidator;

import java.util.regex.Pattern;

@Validator
public class EntrantValidatorImpl extends AbstractValidator implements EntrantValidator {
    private static final Pattern EMAIL_TEMPLATE = Pattern.compile("^\\w{4,}@\\w+.[a-zA-Z]+$");
    private static final Pattern PASSWORD_TEMPLATE = Pattern.compile("^[a-zA-Z0-9]+$");

    @Override
    public void validate(Entrant entrant) {
        if(entrant == null){
            throw new ValidationException("entrant.is.null");
        }

        validateName(entrant.getName());
        validateEmail(entrant.getEmail());
        validatePassword(entrant.getPassword());
    }


    @Override
    public void validatePassword(String password) {
        if(password == null || password.isEmpty()){
            throw new ValidationException("password.cannot.be.empty");
        }
        if(password.length() < MIN_LENGTH || password.length() > MAX_LENGTH){
            throw new ValidationException("password.length.must.be.in.range(3,32)");
        }
        if(!PASSWORD_TEMPLATE.matcher(password).matches()){
            throw new ValidationException("password.must.contain.only.letters.and.numbers");
        }
    }

    @Override
    public void validateEmail(String email) {
        if(email == null || email.isEmpty()){
            throw new ValidationException("email.cannot.be.empty");
        }
        if(email.length() < MIN_LENGTH || email.length() > MAX_LENGTH){
            throw new ValidationException("email.length.must.be.in.range(3,32)");
        }
        if(!EMAIL_TEMPLATE.matcher(email).matches()){
            throw new ValidationException("email.must.match.email.pattern");
        }
    }
}
