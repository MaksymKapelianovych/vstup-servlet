package ua.vstup.entity;

public class FacultyEntity {
    private final Integer id;
    private final String name_ua;
    private final String name_en;
    private final Integer maxBudgetPlace;
    private final Integer maxPlace;
    private final Integer requirementEntityId;
    private final Boolean active;

    private FacultyEntity(Builder builder){
        id = builder.id;
        name_ua = builder.name_ua;
        name_en = builder.name_en;
        maxBudgetPlace = builder.maxBudgetPlace;
        maxPlace = builder.maxPlace;
        requirementEntityId = builder.requirementEntityId;
        active = builder.active;
    }

    public Integer getId() {
        return id;
    }

    public String getName_ua() {
        return name_ua;
    }

    public String getName_en() { return name_en; }

    public Integer getMaxBudgetPlace() {
        return maxBudgetPlace;
    }

    public Integer getMaxPlace() {
        return maxPlace;
    }

    public Integer getRequirementEntityId() { return requirementEntityId; }

    public Boolean getActive() { return active; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder{
        private Integer id;
        private String name_ua;
        private String name_en;
        private Integer maxBudgetPlace;
        private Integer maxPlace;
        private Integer requirementEntityId;
        private Boolean active;


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
        public Builder withRequirementEntityId(Integer requirementEntity){
            this.requirementEntityId = requirementEntity;
            return this;
        }
        public Builder withActive(Boolean active){
            this.active = active;
            return this;
        }
        public FacultyEntity build(){ return new FacultyEntity(this);}

    }
}
