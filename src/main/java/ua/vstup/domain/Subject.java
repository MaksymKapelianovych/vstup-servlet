package ua.vstup.domain;

import ua.vstup.entity.SubjectNameEntity;

public class Subject {
    private final Integer id;
    private final SubjectName name;
    private final Integer rate;

    public Subject(Integer id, SubjectName name, Integer rate) {
        this.id = id;
        this.name = name;
        this.rate = rate;
    }

    public Integer getId() {
        return id;
    }

    public SubjectName getName() {
        return name;
    }

    public Integer getRate() {
        return rate;
    }
}
