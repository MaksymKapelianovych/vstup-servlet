package ua.vstup.domain;

import ua.vstup.entity.SubjectNameEntity;

public class Requirement {
    private final Integer id;
    private final SubjectNameEntity firstSubject;
    private final Integer firstRate;
    private final SubjectNameEntity secondSubject;
    private final Integer secondRate;
    private final SubjectNameEntity thirdSubject;
    private final Integer thirdRate;
    private final SubjectNameEntity fourthSubject;
    private final Integer fourthRate;
    private final SubjectNameEntity fifthSubject;
    private final Integer fifthRate;

    private Requirement(Builder builder) {
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

    public SubjectNameEntity getFirstSubject() {
        return firstSubject;
    }

    public Integer getFirstRate() {
        return firstRate;
    }

    public SubjectNameEntity getSecondSubject() {
        return secondSubject;
    }

    public Integer getSecondRate() {
        return secondRate;
    }

    public SubjectNameEntity getThirdSubject() {
        return thirdSubject;
    }

    public Integer getThirdRate() {
        return thirdRate;
    }

    public SubjectNameEntity getFourthSubject() { return fourthSubject; }

    public Integer getFourthRate() { return fourthRate; }

    public SubjectNameEntity getFifthSubject() { return fifthSubject; }

    public Integer getFifthRate() { return fifthRate; }

    public static class Builder{
        private Integer id;
        private SubjectNameEntity firstSubject;
        private Integer firstRate;
        private SubjectNameEntity secondSubject;
        private Integer secondRate;
        private SubjectNameEntity thirdSubject;
        private Integer thirdRate;
        private SubjectNameEntity fourthSubject;
        private Integer fourthRate;
        private SubjectNameEntity fifthSubject;
        private Integer fifthRate;

        private Builder(){}

        public Builder withId(Integer id){
            this.id = id;
            return this;
        }
        public Builder withFirstSubject(SubjectNameEntity firstSubject){
            this.firstSubject = firstSubject;
            return this;
        }
        public Builder withFirstRate(Integer firstRate){
            this.firstRate = firstRate;
            return this;
        }
        public Builder withSecondSubject(SubjectNameEntity secondSubject){
            this.secondSubject = secondSubject;
            return this;
        }
        public Builder withSecondRate(Integer secondRate){
            this.secondRate = secondRate;
            return this;
        }
        public Builder withThirdSubject(SubjectNameEntity thirdSubject){
            this.thirdSubject = thirdSubject;
            return this;
        }
        public Builder withThirdRate(Integer thirdRate){
            this.thirdRate = thirdRate;
            return this;
        }
        public Builder withFourthSubject(SubjectNameEntity fourthSubject){
            this.fourthSubject = fourthSubject;
            return this;
        }
        public Builder withFourthRate(Integer fourthRate){
            this.fourthRate = fourthRate;
            return this;
        }
        public Builder withFifthSubject(SubjectNameEntity fifthSubject){
            this.fifthSubject = fifthSubject;
            return this;
        }
        public Builder withFifthRate(Integer fifthRate){
            this.fifthRate = fifthRate;
            return this;
        }

        public Requirement build() { return new Requirement(this); }
    }
}
