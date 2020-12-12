package ua.vstup.validator.impl;

import ua.vstup.annotation.Validator;
import ua.vstup.domain.Subject;
import ua.vstup.domain.SubjectName;
import ua.vstup.exception.ValidationException;
import ua.vstup.validator.SubjectValidator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public void validate(List<Subject> subjectList) {
        List<SubjectName> subjectNamesList = new ArrayList<>();
        for(Subject subject: subjectList){
            if(subject != null){
                subjectNamesList.add(subject.getName());
            }
        }
        Set<SubjectName> subjectNamesSet = new HashSet<>(subjectNamesList);
        if(subjectNamesSet.size() != subjectNamesList.size()){
            throw new ValidationException("subjects.must.be.different");
        }

        for(Subject subject: subjectList){
            validate(subject);
        }
    }

    @Override
    public void validate(Subject entity) {
        validateRate(entity.getRate());
    }
}
