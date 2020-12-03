package ua.vstup.entity;

public class EntrantEntity {
    private final Integer id;
    private final String firstname;
    private final String lastname;
    private final String surname;
    private final String email;
    private final String city;
    private final String school;
    private final RoleEntity roleEntity;

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getSchool() {
        return school;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }



    private EntrantEntity(Builder builder) {
        id = builder.id;
        firstname = builder.firstname;
        lastname = builder.lastname;
        surname = builder.surname;
        email = builder.email;
        city = builder.city;
        school = builder.school;
        roleEntity = builder.roleEntity;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Integer id;
        private String firstname;
        private String lastname;
        private String surname;
        private String email;
        private String city;
        private String school;
        private RoleEntity roleEntity;

        private Builder(){}

        public Builder withId(Integer id){
            this.id = id;
            return this;
        }
        public Builder withFirstname(String firstname){
            this.firstname = firstname;
            return this;
        }
        public Builder withLastname(String lastname){
            this.lastname = lastname;
            return this;
        }
        public Builder withSurname(String surname){
            this.surname = surname;
            return this;
        }
        public Builder withEmail(String email){
            this.email = email;
            return this;
        }
        public Builder withCity(String city){
            this.city = city;
            return this;
        }
        public Builder withSchool(String school){
            this.school = school;
            return this;
        }
        public Builder withRoleEntity(RoleEntity roleEntity){
            this.roleEntity = roleEntity;
            return this;
        }

        public EntrantEntity build(){ return new EntrantEntity(this); }
    }

}
