package ua.vstup.entity;

public class RequirementEntity {
    private final Integer id;
    private final Integer firstSubjectId;
    private final Integer secondSubjectId;
    private final Integer thirdSubjectId;

    private RequirementEntity(Builder builder) {
        id = builder.id;
        firstSubjectId = builder.firstSubjectId;
        secondSubjectId = builder.secondSubjectId;
        thirdSubjectId = builder.thirdSubjectId;
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

    public static Builder builder() { return new Builder(); }

    public static class Builder{
        private Integer id;
        private Integer firstSubjectId;
        private Integer secondSubjectId;
        private Integer thirdSubjectId;


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

        public RequirementEntity build() { return new RequirementEntity(this); }
    }
}
