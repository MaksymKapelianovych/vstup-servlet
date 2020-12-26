package ua.vstup.domain;

import ua.vstup.constantutils.Constants;

public class RequestInfo {
    private Integer id;
    private String entrantName;
    private String facultyNameUa;
    private String facultyNameEn;
    private Subject firstSubject;
    private Subject secondSubject;
    private Subject thirdSubject;
    private Integer priority;
    private State state;

    public RequestInfo(Builder builder){
        entrantName = builder.entrantName;
        facultyNameUa = builder.facultyNameUa;
        facultyNameEn = builder.facultyNameEn;
        firstSubject = builder.firstSubject;
        secondSubject = builder.secondSubject;
        thirdSubject = builder.thirdSubject;
        priority = builder.priority;
        state = builder.state;
    }

    public Integer getId() {
        return id;
    }

    public String getEntrantName() {
        return entrantName;
    }

    public String getFacultyNameUa() {
        return facultyNameUa;
    }

    public String getFacultyNameEn() {
        return facultyNameEn;
    }

    public String getFacultyNameByLocale(String locale){
        switch (locale){
            case Constants.Attributes.UA:{
                return facultyNameUa;
            }
            default:{
                return facultyNameEn;
            }
        }
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

    public Integer getPriority() { return priority; }

    public State getState() {
        return state;
    }

    public static Builder builder(){return new Builder();};

    public static class Builder{
        private Integer id;
        private String entrantName;
        private String facultyNameUa;
        private String facultyNameEn;
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

        public Builder withEntrantName(String entrantName){
            this.entrantName = entrantName;
            return this;
        }

        public Builder withFacultyNameUa(String facultyNameUa){
            this.facultyNameUa = facultyNameUa;
            return this;
        }
        public Builder withFacultyNameEn(String facultyNameEn){
            this.facultyNameEn = facultyNameEn;
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
