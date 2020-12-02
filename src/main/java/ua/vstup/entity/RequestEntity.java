package ua.vstup.entity;

public class RequestEntity {
    private final Integer id;
    private final Integer entrantId;
    private final Integer facultyId;

    public Integer getId() {
        return id;
    }

    public Integer getEntrantId() {
        return entrantId;
    }

    public Integer getFacultyId() {
        return facultyId;
    }

    private RequestEntity(Builder builder) {
        id = builder.id;
        entrantId = builder.entrantId;
        facultyId = builder.facultyId;
    }

    public static class Builder{
        private Integer id;
        private Integer entrantId;
        private Integer facultyId;

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

        public RequestEntity build(){ return new RequestEntity(this); }
    }

}
