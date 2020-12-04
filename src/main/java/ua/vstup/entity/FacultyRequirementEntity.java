package ua.vstup.entity;

import ua.vstup.domain.FacultyRequirement;

public class FacultyRequirementEntity {
    private final Integer id;
    private final SubjectEntity firstSubject;
    private final Integer firstRate;
    private final SubjectEntity secondSubject;
    private final Integer secondRate;
    private final SubjectEntity thirdSubject;
    private final Integer thirdRate;
    private final SubjectEntity fourthSubject;
    private final Integer fourthRate;
    private final SubjectEntity fifthSubject;
    private final Integer fifthRate;

    private FacultyRequirementEntity(Builder builder) {
        id = builder.id;
        firstSubject = builder.firstSubject;
        firstRate = builder.firstRate;
        secondSubject = builder.secondSubject;
        secondRate = builder.secondRate;
        thirdSubject = builder.thirdSubject;
        thirdRate = builder.thirdRate;
        fourthSubject = builder.fourthSubject;
        fourthRate = builder.fourthRate;
        fifthSubject = builder.fifthSubject;
        fifthRate = builder.fifthRate;
    }

    public Integer getId() {
        return id;
    }

    public SubjectEntity getFirstSubject() {
        return firstSubject;
    }

    public Integer getFirstRate() {
        return firstRate;
    }

    public SubjectEntity getSecondSubject() {
        return secondSubject;
    }

    public Integer getSecondRate() {
        return secondRate;
    }

    public SubjectEntity getThirdSubject() {
        return thirdSubject;
    }

    public Integer getThirdRate() {
        return thirdRate;
    }

    public SubjectEntity getFourthSubject() { return fourthSubject; }

    public Integer getFourthRate() { return fourthRate; }

    public SubjectEntity getFifthSubject() { return fifthSubject; }

    public Integer getFifthRate() { return fifthRate; }

    public static Builder builder() { return new Builder(); }

    public static class Builder{
        private Integer id;
        private SubjectEntity firstSubject;
        private Integer firstRate;
        private SubjectEntity secondSubject;
        private Integer secondRate;
        private SubjectEntity thirdSubject;
        private Integer thirdRate;
        private SubjectEntity fourthSubject;
        private Integer fourthRate;
        private SubjectEntity fifthSubject;
        private Integer fifthRate;

        private Builder(){}

        public Builder withId(Integer id){
            this.id = id;
            return this;
        }
        public Builder withFirstSubject(SubjectEntity firstSubject){
            this.firstSubject = firstSubject;
            return this;
        }
        public Builder withFirstRate(Integer firstRate){
            this.firstRate = firstRate;
            return this;
        }
        public Builder withSecondSubject(SubjectEntity secondSubject){
            this.secondSubject = secondSubject;
            return this;
        }
        public Builder withSecondRate(Integer secondRate){
            this.secondRate = secondRate;
            return this;
        }
        public Builder withThirdSubject(SubjectEntity thirdSubject){
            this.thirdSubject = thirdSubject;
            return this;
        }
        public Builder withThirdRate(Integer thirdRate){
            this.thirdRate = thirdRate;
            return this;
        }
        public Builder withFourthSubject(SubjectEntity fourthSubject){
            this.fourthSubject = fourthSubject;
            return this;
        }
        public Builder withFourthRate(Integer fourthRate){
            this.fourthRate = fourthRate;
            return this;
        }
        public Builder withFifthSubject(SubjectEntity fifthSubject){
            this.fifthSubject = fifthSubject;
            return this;
        }
        public Builder withFifthRate(Integer fifthRate){
            this.fifthRate = fifthRate;
            return this;
        }

        public FacultyRequirementEntity build() { return new FacultyRequirementEntity(this); }
    }
}
