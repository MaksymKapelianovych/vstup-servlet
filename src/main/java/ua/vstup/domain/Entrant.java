package ua.vstup.domain;


public class Entrant {
    private final Integer id;
    private final String firstname;
    private final String lastname;
    private final String surname;
    private final String email;
    private final String city;

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

    public Role getRole() {
        return role;
    }

    private final String school;
    private final Role role;

    private Entrant(Builder builder) {
        id = builder.id;
        firstname = builder.firstname;
        lastname = builder.lastname;
        surname = builder.surname;
        email = builder.email;
        city = builder.city;
        school = builder.school;
        role = builder.role;
    }

    public static Entrant.Builder builder() { return new Entrant.Builder(); }

    public static class Builder {
        private Integer id;
        private String firstname;
        private String lastname;
        private String surname;
        private String email;
        private String city;
        private String school;
        private Role role;

        private Builder(){}

        public Entrant.Builder withId(Integer id){
            this.id = id;
            return this;
        }
        public Entrant.Builder withFirstname(String firstname){
            this.firstname = firstname;
            return this;
        }
        public Entrant.Builder withLastname(String lastname){
            this.lastname = lastname;
            return this;
        }
        public Entrant.Builder withSurname(String surname){
            this.surname = surname;
            return this;
        }
        public Entrant.Builder withEmail(String email){
            this.email = email;
            return this;
        }
        public Entrant.Builder withCity(String city){
            this.city = city;
            return this;
        }
        public Entrant.Builder withSchool(String school){
            this.school = school;
            return this;
        }
        public Entrant.Builder withRole(Role role){
            this.role = role;
            return this;
        }

        public Entrant build(){ return new Entrant(this); }
    }

}
