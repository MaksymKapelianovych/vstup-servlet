package ua.vstup.entity;

//TODO додати таблицю шкіл, редагує адмін, область винести в таблицю школи, міста просто колонка
//TODO мінімально на факультет 3 предмети, максимально 5
//TODO відомість зберігати після фіналізації

public class EntrantEntity {
    private final Integer id;
    private final String name;
    private final String password;
    private final String email;
    private final Integer schoolEntityId;
    private final RoleEntity roleEntity;
    private final Integer requirementEntityId;
    private final Boolean active;

    private EntrantEntity(Builder builder) {
        id = builder.id;
        name = builder.name;
        password = builder.password;
        email = builder.email;
        schoolEntityId = builder.schoolEntityId;
        roleEntity = builder.roleEntity;
        requirementEntityId = builder.requirementEntityId;
        active = builder.active;
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

    public Integer getSchoolEntityId() {
        return schoolEntityId;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public Integer getRequirementEntityId() { return requirementEntityId; }

    public Boolean getActive() { return active; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Integer id;
        private String name;
        private String password;
        private String email;
        private Integer schoolEntityId;
        private RoleEntity roleEntity;
        private Integer requirementEntityId;
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
        public Builder withPassword(String password){
            this.password = password;
            return this;
        }
        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder withSchoolEntityId(Integer schoolEntity){
            this.schoolEntityId = schoolEntity;
            return this;
        }
        public Builder withRoleEntity(RoleEntity roleEntity){
            this.roleEntity = roleEntity;
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

        public EntrantEntity build(){ return new EntrantEntity(this); }
    }

}
