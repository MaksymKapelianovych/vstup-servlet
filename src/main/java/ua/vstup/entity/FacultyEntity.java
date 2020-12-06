package ua.vstup.entity;

public class FacultyEntity {
    private final Integer id;
    private final String name;
    private final Integer maxBudgetPlace;
    private final Integer maxPlace;
    private final Integer requirementEntityId;

    private FacultyEntity(Builder builder){
        id = builder.id;
        name = builder.name;
        maxBudgetPlace = builder.maxBudgetPlace;
        maxPlace = builder.maxPlace;
        requirementEntityId = builder.requirementEntityId;
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

    public Integer getRequirementEntityId() { return requirementEntityId; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder{
        private Integer id;
        private String name;
        private Integer maxBudgetPlace;
        private Integer maxPlace;
        private Integer requirementEntityId;

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
        public Builder withRequirementEntityId(Integer requirementEntity){
            this.requirementEntityId = requirementEntity;
            return this;
        }
        public FacultyEntity build(){ return new FacultyEntity(this);}

    }
}
