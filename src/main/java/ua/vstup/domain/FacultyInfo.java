package ua.vstup.domain;

public class FacultyInfo {
    private Integer id;
    private String name_ua;
    private String name_en;
    private Integer maxBudgetPlace;
    private Integer maxPlace;
    private RequirementInfo requirementInfo;

    private FacultyInfo(Builder builder){
        id = builder.id;
        name_ua = builder.name_ua;
        name_en = builder.name_en;
        maxBudgetPlace = builder.maxBudgetPlace;
        maxPlace = builder.maxPlace;
        requirementInfo = builder.requirementInfo;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private String name_ua;
        private String name_en;
        private Integer maxBudgetPlace;
        private Integer maxPlace;
        private RequirementInfo requirementInfo;

        private Builder() {
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withNameUa(String name) {
            this.name_ua = name;
            return this;
        }

        public Builder withNameEn(String name) {
            this.name_en = name;
            return this;
        }

        public Builder withMaxBudgetPlace(Integer maxBudgetPlace) {
            this.maxBudgetPlace = maxBudgetPlace;
            return this;
        }

        public Builder withMaxPlace(Integer maxPlace) {
            this.maxPlace = maxPlace;
            return this;
        }

        public Builder withRequirementInfo(RequirementInfo requirementInfo) {
            this.requirementInfo = requirementInfo;
            return this;
        }

        public FacultyInfo build() {
            return new FacultyInfo(this);
        }
    }
}
