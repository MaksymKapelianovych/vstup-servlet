package ua.vstup.domain;

import ua.vstup.entity.SubjectNameEntity;

public class Requirement {
    private final Integer id;
    private final Integer firstSubjectId;
    private final Integer secondSubjectId;
    private final Integer thirdSubjectId;
    private final Integer fourthSubjectId;
    private final Integer fifthSubjectId;

    private Requirement(Builder builder) {
        id = builder.id;
        firstSubjectId = builder.firstSubjectId;
        secondSubjectId = builder.secondSubjectId;
        thirdSubjectId = builder.thirdSubjectId;
        fourthSubjectId = builder.fourthSubjectId;
        fifthSubjectId = builder.fifthSubjectId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getFirstSubjectId() {
        return firstSubjectId;
    }

    public Integer getSecondSubjectId() {
        return secondSubjectId;
    }

    public Integer getThirdSubjectId() {
        return thirdSubjectId;
    }

    public Integer getFourthSubjectId() {
        return fourthSubjectId;
    }

    public Integer getFifthSubjectId() {
        return fifthSubjectId;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder{
        private Integer id;
        private Integer firstSubjectId;
        private Integer secondSubjectId;
        private Integer thirdSubjectId;
        private Integer fourthSubjectId;
        private Integer fifthSubjectId;

        private Builder(){}

        public Builder withId(Integer id){
            this.id = id;
            return this;
        }
        public Builder withFirstSubjectId(Integer firstSubject){
            this.firstSubjectId = firstSubject;
            return this;
        }
        public Builder withSecondSubjectId(Integer secondSubject){
            this.secondSubjectId = secondSubject;
            return this;
        }
        public Builder withThirdSubjectId(Integer thirdSubject){
            this.thirdSubjectId = thirdSubject;
            return this;
        }
        public Builder withFourthSubjectId(Integer fourthSubject){
            this.fourthSubjectId = fourthSubject;
            return this;
        }
        public Builder withFifthSubjectId(Integer fifthSubject){
            this.fifthSubjectId = fifthSubject;
            return this;
        }

        public Requirement build() { return new Requirement(this); }
    }
}
