package ua.vstup.entity;

//TODO додати таблицю шкіл, редагує адмін, область винести в таблицю школи, міста просто колонка
//TODO мінімально на факультет 3 предмети, максимально 5
//TODO відомість зберігати після фіналізації

public class EntrantEntity {
    private final Integer id;
    private final String fullname;
    private final String email;
    private final SchoolEntity schoolEntity;
    private final RoleEntity roleEntity;

    public Integer getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }


    public SchoolEntity getSchoolEntity() {
        return schoolEntity;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    private EntrantEntity(Builder builder) {
        id = builder.id;
        fullname = builder.fullname;
        email = builder.email;
        schoolEntity = builder.schoolEntity;
        roleEntity = builder.roleEntity;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Integer id;
        private String fullname;
        private String email;
        private SchoolEntity schoolEntity;
        private RoleEntity roleEntity;

        private Builder(){}

        public Builder withId(Integer id){
            this.id = id;
            return this;
        }
        public Builder withFullname(String fullname){
            this.fullname = fullname;
            return this;
        }
        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder withSchoolEntity(SchoolEntity schoolEntity){
            this.schoolEntity = schoolEntity;
            return this;
        }
        public Builder withRoleEntity(RoleEntity roleEntity){
            this.roleEntity = roleEntity;
            return this;
        }

        public EntrantEntity build(){ return new EntrantEntity(this); }
    }

}
