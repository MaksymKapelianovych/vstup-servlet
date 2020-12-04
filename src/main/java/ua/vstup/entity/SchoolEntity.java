package ua.vstup.entity;

public class SchoolEntity {
    private final Integer id;
    private final String name;
    private final String city;
    private final RegionEntity regionEntity;

    private SchoolEntity(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.city = builder.city;
        this.regionEntity = builder.regionEntity;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getCity() {
        return city;
    }

    public RegionEntity getRegionEntity() {
        return regionEntity;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder{
        private Integer id;
        private String name;
        private String city;
        private RegionEntity regionEntity;

        private Builder(){}

        public Builder withId(Integer id){
            this.id = id;
            return this;
        }
        public Builder withName(String name){
            this.name = name;
            return this;
        }
        public Builder withCity(String city){
            this.city = city;
            return this;
        }
        public Builder withRegionEntity(RegionEntity regionEntity){
            this.regionEntity = regionEntity;
            return this;
        }

        public SchoolEntity build() { return new SchoolEntity(this); }
    }
}
