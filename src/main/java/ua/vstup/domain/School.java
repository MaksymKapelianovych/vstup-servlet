package ua.vstup.domain;

public class School {
    private Integer id;
    private String name_ua;
    private String name_en;
    private String city_ua;
    private String city_en;
    private Region region;

    public School(Builder builder) {
        id = builder.id;
        name_ua = builder.name_ua;
        name_en = builder.name_en;
        city_ua = builder.city_ua;
        city_en = builder.city_en;
        region = builder.region;
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

    public Region getRegion() {
        return region;
    }

    public String getName_en() { return name_en; }

    public String getCity_en() { return city_en; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Integer id;
        private String name_ua;
        private String name_en;
        private String city_ua;
        private String city_en;
        private Region region;

        private Builder() {
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withNameUa(String name) {
            this.name_ua = name;
            return this;
        }

        public Builder withNameEn(String name) {
            this.name_en = name;
            return this;
        }

        public Builder withCityUa(String city) {
            this.city_ua = city;
            return this;
        }
        public Builder withCityEn(String city) {
            this.city_en = city;
            return this;
        }

        public Builder withRegion(Region region) {
            this.region = region;
            return this;
        }

        public School build() {
            return new School(this);
        }
    }
}
