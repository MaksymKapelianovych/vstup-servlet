package ua.vstup.domain;

public class EntrantInfo {
    private Integer id;
    private String name;
    private String email;
    private School school;
    private Role role;
    private RequirementInfo requirementInfo;
    private boolean passed;

    public EntrantInfo(Builder builder){
        id = builder.id;
        name = builder.name;
        email = builder.email;
        school = builder.school;
        role = builder.role;
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

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public static Builder builder() {return new Builder(); }

    public Role getRole() {
        return role;
    }

    public static class Builder{
        private Integer id;
        private String name;
        private String email;
        private School school;
        private Role role;
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
            this.email = email;
            return this;
        }
        public Builder withSchool(School school){
            this.school = school;
            return this;
        }
        public Builder withRole(Role role){
            this.role = role;
            return this;
        }
        public Builder withRequirementInfo(RequirementInfo requirementInfo){
            this.requirementInfo = requirementInfo;
            return this;
        }

        public EntrantInfo build() { return new EntrantInfo(this); }
    }
}
