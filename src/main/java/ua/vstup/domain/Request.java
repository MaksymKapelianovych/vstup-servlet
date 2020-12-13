package ua.vstup.domain;

import ua.vstup.entity.StateEntity;

public class Request {
    private Integer id;
    private Integer entrantId;
    private Integer facultyId;
    private Integer firstSubjectId;
    private Integer secondSubjectId;
    private Integer thirdSubjectId;
    private Integer statementId;
    private State state;

    private Request(Builder builder) {
        id = builder.id;
        entrantId = builder.entrantId;
        facultyId = builder.facultyId;
        firstSubjectId = builder.firstSubjectId;
        secondSubjectId = builder.secondSubjectId;
        thirdSubjectId = builder.thirdSubjectId;
        statementId = builder.statementId;
        state = builder.state;
    }

    public Integer getId() {
        return id;
    }

    public Integer getEntrantId() {
        return entrantId;
    }

    public Integer getFacultyId() {
        return facultyId;
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

    public Integer getStatementId() { return statementId; }

    public State getState() { return state; }

    public static Builder builder() { return new Builder(); }

    public static class Builder{
        private Integer id;
        private Integer entrantId;
        private Integer facultyId;
        private Integer firstSubjectId;
        private Integer secondSubjectId;
        private Integer thirdSubjectId;
        private Integer statementId;
        private State state;

        private Builder(){}

        public Builder withId(Integer id){
            this.id = id;
            return this;
        }
        public Builder withEntrantId(Integer entrantId){
            this.entrantId = entrantId;
            return this;
        }
        public Builder withFacultyId(Integer facultyId){
            this.facultyId = facultyId;
            return this;
        }
        public Builder withFirstSubjectId(Integer firstSubjectId){
            this.firstSubjectId = firstSubjectId;
            return this;
        }
        public Builder withSecondSubjectId(Integer secondSubjectId){
            this.secondSubjectId = secondSubjectId;
            return this;
        }
        public Builder withThirdSubjectId(Integer thirdSubjectId){
            this.thirdSubjectId = thirdSubjectId;
            return this;
        }
        public Builder withStatementId(Integer statementId){
            this.statementId = statementId;
            return this;
        }
        public Builder withState(State state){
            this.state = state;
            return this;
        }

        public Request build(){ return new Request(this); }
    }

}
