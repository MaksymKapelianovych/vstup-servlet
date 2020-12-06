package ua.vstup.entity;

//TODO додати таблицю шкіл, редагує адмін, область винести в таблицю школи, міста просто колонка
//TODO мінімально на факультет 3 предмети, максимально 5
//TODO відомість зберігати після фіналізації

public class EntrantEntity {
    private final Integer id;
    private final String name;
    private final String password;
    private final String email;
    private final SchoolEntity schoolEntity;
    private final RoleEntity roleEntity;
    private final RequirementEntity requirementEntity;

    private EntrantEntity(Builder builder) {
        id = builder.id;
        name = builder.name;
        password = builder.password;
        email = builder.email;
        schoolEntity = builder.schoolEntity;
        roleEntity = builder.roleEntity;
        requirementEntity = builder.requirementEntity;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() { return password; }

    public String getEmail() {
        return email;
    }

    public SchoolEntity getSchoolEntity() {
        return schoolEntity;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public RequirementEntity getRequirementEntity() { return requirementEntity; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Integer id;
        private String name;
        private String password;
        private String email;
        private SchoolEntity schoolEntity;
        private RoleEntity roleEntity;
        private RequirementEntity requirementEntity;


        private Builder(){}

        public Builder withId(Integer id){
            this.id = id;
            return this;
        }
        public Builder withName(String name){
            this.name = name;
            return this;
        }
        public Builder withPassword(String password){
            this.password = password;
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
        public Builder withRequirementEntity(RequirementEntity requirementEntity){
            this.requirementEntity = requirementEntity;
            return this;
        }

        public EntrantEntity build(){ return new EntrantEntity(this); }
    }

}
