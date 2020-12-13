package ua.vstup.domain;

public class Faculty {
    private Integer id;
    private String name_ua;
    private String name_en;
    private Integer maxBudgetPlace;
    private Integer maxPlace;
    private Requirement requirement;

    private Faculty(Builder builder){
        id = builder.id;
        name_ua = builder.name_ua;
        name_en = builder.name_en;
        maxBudgetPlace = builder.maxBudgetPlace;
        maxPlace = builder.maxPlace;
        requirement = builder.requirement;
    }

    public Integer getId() {
        return id;
    }

    public String getName_ua() {
        return name_ua;
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
        private String name_ua;
        private String name_en;
        private Integer maxBudgetPlace;
        private Integer maxPlace;
        private Requirement requirement;

        private Builder(){}

        public Builder withId(Integer id){
            this.id = id;
            return this;
        }
        public Builder withNameUa(String name){
            this.name_ua = name;
            return this;
        }
        public Builder withNameEn(String name){
            this.name_en = name;
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
