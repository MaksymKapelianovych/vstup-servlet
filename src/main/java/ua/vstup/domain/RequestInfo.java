package ua.vstup.domain;

public class RequestInfo {
    private Integer id;
    private EntrantInfo entrant;
    private FacultyInfo faculty;
    private Subject firstSubject;
    private Subject secondSubject;
    private Subject thirdSubject;
    private Integer priority;
    private State state;

    public RequestInfo(Builder builder){
        id = builder.id;
        entrant = builder.entrant;
        faculty = builder.faculty;
        firstSubject = builder.firstSubject;
        secondSubject = builder.secondSubject;
        thirdSubject = builder.thirdSubject;
        priority = builder.priority;
        state = builder.state;
    }

    public Integer getId() {
        return id;
    }

    public EntrantInfo getEntrant() {
        return entrant;
    }

    public FacultyInfo getFaculty() {
        return faculty;
    }

    public Subject getFirstSubject() {
        return firstSubject;
    }

    public Subject getSecondSubject() {
        return secondSubject;
    }

    public Subject getThirdSubject() {
        return thirdSubject;
    }

    public Integer getRate() {
        return getFirstSubject().getRate() +
                getSecondSubject().getRate() +
                getThirdSubject().getRate();
    }

    public Integer getPriority() { return priority; }

    public State getState() {
        return state;
    }

    public static Builder builder(){return new Builder();};

    public void setState(State state) {
        this.state = state;
    }

    public void setFaculty(FacultyInfo faculty) {
        this.faculty = faculty;
    }

    public static class Builder{
        private Integer id;
        private EntrantInfo entrant;
        private FacultyInfo faculty;
        private Subject firstSubject;
        private Subject secondSubject;
        private Subject thirdSubject;
        private Integer priority;
        private State state;

        private Builder(){}

        public Builder withId(Integer id){
            this.id = id;
            return this;
        }

        public Builder withEntrant(EntrantInfo entrant){
            this.entrant = entrant;
            return this;
        }

        public Builder withFaculty(FacultyInfo faculty){
            this.faculty = faculty;
            return this;
        }
        public Builder withFirstSubject(Subject firstSubject){
            this.firstSubject = firstSubject;
            return this;
        }
        public Builder withSecondSubject(Subject secondSubject){
            this.secondSubject = secondSubject;
            return this;
        }
        public Builder withThirdSubject(Subject thirdSubject){
            this.thirdSubject = thirdSubject;
            return this;
        }
        public Builder withPriority(Integer priority){
            this.priority = priority;
            return this;
        }
        public Builder withState(State state){
            this.state = state;
            return this;
        }

        public RequestInfo build(){ return new RequestInfo(this);}
    }
}
