package ua.vstup.validator.impl;

import ua.vstup.exception.ValidationException;

import java.util.regex.Pattern;

public class AbstractValidator {
    private static final Pattern NAME_TEMPLATE = Pattern.compile("^[a-zA-Zа-яА-Я ]+$");
    protected static final Integer MIN_LENGTH = 3;
    protected static final Integer MAX_LENGTH = 32;

    protected void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new ValidationException("name.cant.be.empty");
        }
        if (!NAME_TEMPLATE.matcher(name).matches()) {
            throw new ValidationException("name.should.contains.letter.only");
        }
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new ValidationException("name.length.should.be.in.range(3,32)");
        }
    }

    protected void validateInteger(Integer value) {
        if (value == null || value < 0) {
            throw new ValidationException("value.cant.be.less.then.0");
        }
    }

}
