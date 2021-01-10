package ua.vstup.entity;

public class SchoolEntity {
    private final Integer id;
    private final String name_ua;
    private final String name_en;
    private final String city_ua;
    private final String city_en;
    private final RegionEntity regionEntity;

    private SchoolEntity(Builder builder) {
        this.id = builder.id;
        this.name_ua = builder.name_ua;
        this.name_en = builder.name_en;
        this.city_ua = builder.city_ua;
        this.city_en = builder.city_en;
        this.regionEntity = builder.regionEntity;
    }

    public Integer getId() {
        return id;
    }

    public String getName_ua() {
        return name_ua;
    }

    public String getCity_ua() {
        return city_ua;
    }

    public String getName_en() { return name_en; }

    public String getCity_en() { return city_en; }

    public RegionEntity getRegionEntity() {
        return regionEntity;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder{
        private Integer id;
        private String name_ua;
        private String name_en;
        private String city_ua;
        private String city_en;
        private RegionEntity regionEntity;

        private Builder(){}

        public Builder withId(Integer id){
            this.id = id;
            return this;
        }
        public Builder withNameUa(String name_ua){
            this.name_ua = name_ua;
            return this;
        }
        public Builder withNameEn(String name_en){
            this.name_en = name_en;
            return this;
        }
        public Builder withCityUa(String city_ua){
            this.city_ua = city_ua;
            return this;
        }
        public Builder withCityEn(String city_en){
            this.city_en = city_en;
            return this;
        }
        public Builder withRegionEntity(RegionEntity regionEntity){
            this.regionEntity = regionEntity;
            return this;
        }

        public SchoolEntity build() { return new SchoolEntity(this); }
    }
}
