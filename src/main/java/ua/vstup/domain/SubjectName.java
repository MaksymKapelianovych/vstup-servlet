package ua.vstup.domain;

import ua.vstup.constantutils.Constants;

public enum SubjectName {
    MATH("Math", "Математика"),
    UKRAINIAN("Ukrainian", "Українська мова"),
    ENGLISH("English","Англійська мова"),
    HISTORY("History", "Історія"),
    PHYSICS("Physics","Фізика");

    private String name_ua;
    private String name_en;

    SubjectName(String name_en, String name_ua){
        this.name_en = name_en;
        this.name_ua = name_ua;
    }

    public String getNameByLocale(String locale){
        switch (locale){
            case Constants.Attributes.UA:{
                return name_ua;
            }
            default:{
                return name_en;
            }
        }
    }
}
