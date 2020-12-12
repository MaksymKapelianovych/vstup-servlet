package ua.vstup.domain;

public class Faculty {
    private Integer id;
    private String name;
    private Integer maxBudgetPlace;
    private Integer maxPlace;
    private Requirement requirement;

    private Faculty(Builder builder){
        id = builder.id;
        name = builder.name;
        maxBudgetPlace = builder.maxBudgetPlace;
        maxPlace = builder.maxPlace;
        requirement = builder.requirement;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getMaxBudgetPlace() {
        return maxBudgetPlace;
    }

    public Integer getMaxPlace() {
        return maxPlace;
    }

    public Requirement getFacultyRequirement() { return requirement; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder{
        private Integer id;
        private String name;
        private Integer maxBudgetPlace;
        private Integer maxPlace;
        private Requirement requirement;

        private Builder(){}

        public Builder withId(Integer id){
            this.id = id;
            return this;
        }
        public Builder withName(String name){
            this.name = name;
            return this;
        }
        public Builder withMaxBudgetPlace(Integer maxBudgetPlace){
            this.maxBudgetPlace = maxBudgetPlace;
            return this;
        }
        public Builder withMaxPlace(Integer maxPlace){
            this.maxPlace = maxPlace;
            return this;
        }
        public Builder withFacultyRequirement(Requirement requirement){
            this.requirement = requirement;
            return this;
        }
        public Faculty build(){ return new Faculty(this);}

    }
}
