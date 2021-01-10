package ua.vstup.domain;

public class RequestInfoForEntrant {
    private Faculty faculty;
    private Subject firstSubject;
    private Subject secondSubject;
    private Subject thirdSubject;
    private State state;

    public RequestInfoForEntrant(Builder builder){
        faculty = builder.faculty;
        firstSubject = builder.firstSubject;
        secondSubject = builder.secondSubject;
        thirdSubject = builder.thirdSubject;
        state = builder.state;
    }

    public Faculty getFaculty() {
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

    public State getState() {
        return state;
    }

    public static Builder builder(){return new Builder();};

    public static class Builder{
        private Faculty faculty;
        private Subject firstSubject;
        private Subject secondSubject;
        private Subject thirdSubject;
        private State state;

        private Builder(){};

        public Builder withFaculty(Faculty faculty){
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
        public Builder withState(State state){
            this.state = state;
            return this;
        }

        public RequestInfoForEntrant build(){ return new RequestInfoForEntrant(this);}
    }
}
