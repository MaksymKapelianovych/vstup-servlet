package ua.vstup.domain;

public class EntrantInfo {
    private Integer id;
    private String name;
    private String email;
    private School school;
    private RequirementInfo requirementInfo;

    public EntrantInfo(Builder builder){
        id = builder.id;
        name = builder.name;
        email = builder.email;
        school = builder.school;
        requirementInfo = builder.requirementInfo;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public School getSchool() {
        return school;
    }

    public RequirementInfo getRequirementInfo() {
        return requirementInfo;
    }

    public static Builder builder() {return new Builder(); }

    public static class Builder{
        private Integer id;
        private String name;
        private String email;
        private School school;
        private RequirementInfo requirementInfo;

        private Builder(){}
        public Builder withId(Integer id){
            this.id = id;
            return this;
        }
        public Builder withName(String name){
            this.name = name;
            return this;
        }
        public Builder withEmail(String email){
            this.name = name;
            return this;
        }
        public Builder withSchool(School school){
            this.school = school;
            return this;
        }
        public Builder withRequirementInfo(RequirementInfo requirementInfo){
            this.requirementInfo = requirementInfo;
            return this;
        }

        public EntrantInfo build() { return new EntrantInfo(this); }
    }
}
