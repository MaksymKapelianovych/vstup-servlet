package ua.vstup.domain;


import com.sun.org.apache.xpath.internal.operations.Bool;

public class Entrant {
    private final Integer id;
    private final String name;
    private final String email;
    private final String password;
    private final Integer schoolId;
    private final Role role;
    private final Integer requirementId;
    private final Boolean active;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() { return password; }

    public Integer getSchoolId() {
        return schoolId;
    }

    public Role getRole() {
        return role;
    }

    public Integer getRequirementId() { return requirementId; }

    public Boolean getActive() { return active; }

    private Entrant(Builder builder) {
        id = builder.id;
        name = builder.name;
        email = builder.email;
        password = builder.password;
        schoolId = builder.schoolId;
        role = builder.role;
        requirementId = builder.requirementId;
        active = builder.active;
    }

    public static Entrant.Builder builder() { return new Entrant.Builder(); }

    public static class Builder {
        private Integer id;
        private String name;
        private String email;
        private String password;
        private Integer schoolId;
        private Role role;
        private Integer requirementId;
        private Boolean active;

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
        public Builder withPassword(String password){
            this.password = password;
            return this;
        }
        public Builder withSchoolId(Integer schoolId){
            this.schoolId = schoolId;
            return this;
        }
        public Builder withRole(Role role){
            this.role = role;
            return this;
        }
        public Builder withRequirementId(Integer requirementId){
            this.requirementId = requirementId;
            return this;
        }
        public Builder withActive(Boolean active){
            this.active = active;
            return this;
        }

        public Entrant build(){ return new Entrant(this); }
    }

}
