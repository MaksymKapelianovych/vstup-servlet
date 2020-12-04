package ua.vstup.domain;

public class Request {
    private final Integer id;
    private final Integer entrantId;
    private final Integer facultyId;
    private final Integer firstRate;
    private final Integer secondRate;
    private final Integer thirdRate;

    private Request(Builder builder) {
        id = builder.id;
        entrantId = builder.entrantId;
        facultyId = builder.facultyId;
        firstRate = builder.firstRate;
        secondRate = builder.secondRate;
        thirdRate = builder.thirdRate;
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

    public Integer getFirstRate() {
        return firstRate;
    }

    public Integer getSecondRate() {
        return secondRate;
    }

    public Integer getThirdRate() {
        return thirdRate;
    }

    public static class Builder{
        private Integer id;
        private Integer entrantId;
        private Integer facultyId;
        private Integer firstRate;
        private Integer secondRate;
        private Integer thirdRate;

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
        public Builder withFirstRate(Integer firstRate){
            this.firstRate = firstRate;
            return this;
        }
        public Builder withSecondRate(Integer secondRate){
            this.secondRate = secondRate;
            return this;
        }
        public Builder withThirdRate(Integer thirdRate){
            this.thirdRate = thirdRate;
            return this;
        }

        public Request build(){ return new Request(this); }
    }

}
