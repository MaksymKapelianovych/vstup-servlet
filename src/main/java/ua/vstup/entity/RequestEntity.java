package ua.vstup.entity;

public class RequestEntity {
    private final Integer id;
    private final Integer entrantEntityId;
    private final Integer facultyEntityId;
    private final Integer firstSubjectEntityId;
    private final Integer secondSubjectEntityId;
    private final Integer thirdSubjectEntityId;
    private final Integer statementEntityId;
    private final StateEntity stateEntity;

    private RequestEntity(Builder builder) {
        id = builder.id;
        entrantEntityId = builder.entrantEntityId;
        facultyEntityId = builder.facultyEntityId;
        firstSubjectEntityId = builder.firstSubjectEntityId;
        secondSubjectEntityId = builder.secondSubjectEntityId;
        thirdSubjectEntityId = builder.thirdSubjectEntityId;
        statementEntityId = builder.statementEntityId;
        stateEntity = builder.stateEntity;
    }

    public Integer getId() {
        return id;
    }

    public Integer getEntrantEntityId() {
        return entrantEntityId;
    }

    public Integer getFacultyEntityId() {
        return facultyEntityId;
    }

    public Integer getFirstSubjectEntityId() {
        return firstSubjectEntityId;
    }

    public Integer getSecondSubjectEntityId() {
        return secondSubjectEntityId;
    }

    public Integer getThirdSubjectEntityId() {
        return thirdSubjectEntityId;
    }

    public Integer getStatementEntityId() { return statementEntityId; }

    public StateEntity getStateEntity() { return stateEntity; }

    public static Builder builder() { return new Builder(); }

    public static class Builder{
        private Integer id;
        private Integer entrantEntityId;
        private Integer facultyEntityId;
        private Integer firstSubjectEntityId;
        private Integer secondSubjectEntityId;
        private Integer thirdSubjectEntityId;
        private Integer statementEntityId;
        private StateEntity stateEntity;

        private Builder(){}

        public Builder withId(Integer id){
            this.id = id;
            return this;
        }
        public Builder withEntrantEntityId(Integer entrantId){
            this.entrantEntityId = entrantId;
            return this;
        }
        public Builder withFacultyEntityId(Integer facultyId){
            this.facultyEntityId = facultyId;
            return this;
        }
        public Builder withFirstSubjectEntityId(Integer firstSubjectEntity){
            this.firstSubjectEntityId = firstSubjectEntity;
            return this;
        }
        public Builder withSecondSubjectEntityId(Integer secondSubjectEntity){
            this.secondSubjectEntityId = secondSubjectEntity;
            return this;
        }
        public Builder withThirdSubjectEntityId(Integer thirdSubjectEntity){
            this.thirdSubjectEntityId = thirdSubjectEntity;
            return this;
        }
        public Builder withStatementEntityId(Integer statementId){
            this.statementEntityId = statementId;
            return this;
        }
        public Builder withStateEntity(StateEntity stateEntity){
            this.stateEntity = stateEntity;
            return this;
        }

        public RequestEntity build(){ return new RequestEntity(this); }
    }

}
