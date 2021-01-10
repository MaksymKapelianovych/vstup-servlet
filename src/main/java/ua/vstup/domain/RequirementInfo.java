package ua.vstup.domain;


import java.util.Arrays;
import java.util.List;

public class RequirementInfo {
    private Subject firstSubject;
    private Subject secondSubject;
    private Subject thirdSubject;

    private RequirementInfo(Builder builder) {
        firstSubject = builder.firstSubject;
        secondSubject = builder.secondSubject;
        thirdSubject = builder.thirdSubject;

    }

    public Subject getFirstSubject() {
        return firstSubject;
    }

    public Subject getSecondSubject() {
        return secondSubject;
    }

    public Subject getThirdSubject() {
        return thirdSubject;
    }


    public List<Subject> getSubjectList() { return Arrays.asList(firstSubject, secondSubject, thirdSubject);}

    public Subject getSubjectBySubjectName(SubjectName subjectName){
        return getSubjectList().stream()
                .filter(subject -> subject.getName().equals(subjectName))
                .findFirst()
                .orElse(null);
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder{
        private Subject firstSubject;
        private Subject secondSubject;
        private Subject thirdSubject;

        private Builder(){}

        public Builder withFirstSubject(Subject firstSubject){
            this.firstSubject = firstSubject;
            return this;
        }
        public Builder withSecondSubject(Subject secondSubject){
            this.secondSubject = secondSubject;
            return this;
        }
        public Builder withThirdSubject(Subject thirdSubject){
            this.thirdSubject = thirdSubject;
            return this;
        }

        public RequirementInfo build() { return new RequirementInfo(this); }
    }
}
