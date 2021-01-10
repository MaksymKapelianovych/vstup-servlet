package ua.vstup.validator;

public interface Validator<E> {
    void validate(E entity);
}
