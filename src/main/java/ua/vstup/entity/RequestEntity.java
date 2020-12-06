package ua.vstup.entity;

public class RequestEntity {
    private final Integer id;
    private final Integer entrantId;
    private final Integer facultyId;
    private final SubjectEntity firstSubjectEntity;
    private final SubjectEntity secondSubjectEntity;
    private final SubjectEntity thirdSubjectEntity;
    private final Integer statementId;
    private final StateEntity stateEntity;

    private RequestEntity(Builder builder) {
        id = builder.id;
        entrantId = builder.entrantId;
        facultyId = builder.facultyId;
        firstSubjectEntity = builder.firstSubjectEntity;
        secondSubjectEntity = builder.secondSubjectEntity;
        thirdSubjectEntity = builder.thirdSubjectEntity;
        statementId = builder.statementId;
        stateEntity = builder.stateEntity;
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

    public SubjectEntity getFirstSubjectEntity() {
        return firstSubjectEntity;
    }

    public SubjectEntity getSecondSubjectEntity() {
        return secondSubjectEntity;
    }

    public SubjectEntity getThirdSubjectEntity() {
        return thirdSubjectEntity;
    }

    public Integer getStatementId() { return statementId; }

    public StateEntity getStateEntity() { return stateEntity; }

    public static Builder builder() { return new Builder(); }

    public static class Builder{
        private Integer id;
        private Integer entrantId;
        private Integer facultyId;
        private SubjectEntity firstSubjectEntity;
        private SubjectEntity secondSubjectEntity;
        private SubjectEntity thirdSubjectEntity;
        private Integer statementId;
        private StateEntity stateEntity;

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
        public Builder withFirstSubjectEntity(SubjectEntity firstSubjectEntity){
            this.firstSubjectEntity = firstSubjectEntity;
            return this;
        }
        public Builder withSecondSubjectEntity(SubjectEntity secondSubjectEntity){
            this.secondSubjectEntity = secondSubjectEntity;
            return this;
        }
        public Builder withThirdSubjectEntity(SubjectEntity thirdSubjectEntity){
            this.thirdSubjectEntity = thirdSubjectEntity;
            return this;
        }
        public Builder withStatementId(Integer statementId){
            this.statementId = statementId;
            return this;
        }
        public Builder withStateEntity(StateEntity stateEntity){
            this.stateEntity = stateEntity;
            return this;
        }

        public RequestEntity build(){ return new RequestEntity(this); }
    }

}
