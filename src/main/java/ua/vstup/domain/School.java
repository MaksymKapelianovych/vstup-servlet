package ua.vstup.domain;

import ua.vstup.entity.RegionEntity;
import ua.vstup.entity.SchoolEntity;

public class School {
    private Integer id;
    private String name;
    private String city;
    private Region region;
    private Boolean active;

    public School(Builder builder) {
        id = builder.id;
        name = builder.name;
        city = builder.city;
        region = builder.region;
        active = builder.active;
    }


    public static class Builder {
        private Integer id;
        private String name;
        private String city;
        private Region region;
        private Boolean active;

        private Builder() {
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Builder withRegion(Region region) {
            this.region = region;
            return this;
        }

        public Builder withActive(Boolean active) {
            this.active = active;
            return this;
        }

        public School build() {
            return new School(this);
        }
    }
}
