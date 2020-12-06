package ua.vstup.entity;

public class RequirementEntity {
    private final Integer id;
    private final SubjectEntity firstSubject;
    private final SubjectEntity secondSubject;
    private final SubjectEntity thirdSubject;
    private final SubjectEntity fourthSubject;
    private final SubjectEntity fifthSubject;

    private RequirementEntity(Builder builder) {
        id = builder.id;
        firstSubject = builder.firstSubject;
        secondSubject = builder.secondSubject;
        thirdSubject = builder.thirdSubject;
        fourthSubject = builder.fourthSubject;
        fifthSubject = builder.fifthSubject;
    }

    public Integer getId() {
        return id;
    }

    public SubjectEntity getFirstSubject() {
        return firstSubject;
    }

    public SubjectEntity getSecondSubject() {
        return secondSubject;
    }

    public SubjectEntity getThirdSubject() {
        return thirdSubject;
    }

    public SubjectEntity getFourthSubject() { return fourthSubject; }

    public SubjectEntity getFifthSubject() { return fifthSubject; }

    public static Builder builder() { return new Builder(); }

    public static class Builder{
        private Integer id;
        private SubjectEntity firstSubject;
        private SubjectEntity secondSubject;
        private SubjectEntity thirdSubject;
        private SubjectEntity fourthSubject;
        private SubjectEntity fifthSubject;

        private Builder(){}

        public Builder withId(Integer id){
            this.id = id;
            return this;
        }
        public Builder withFirstSubject(SubjectEntity firstSubject){
            this.firstSubject = firstSubject;
            return this;
        }
        public Builder withSecondSubject(SubjectEntity secondSubject){
            this.secondSubject = secondSubject;
            return this;
        }
        public Builder withThirdSubject(SubjectEntity thirdSubject){
            this.thirdSubject = thirdSubject;
            return this;
        }
        public Builder withFourthSubject(SubjectEntity fourthSubject){
            this.fourthSubject = fourthSubject;
            return this;
        }
        public Builder withFifthSubject(SubjectEntity fifthSubject){
            this.fifthSubject = fifthSubject;
            return this;
        }

        public RequirementEntity build() { return new RequirementEntity(this); }
    }
}
