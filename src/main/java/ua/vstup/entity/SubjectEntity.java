package ua.vstup.entity;

public class SubjectEntity {
    private final Integer id;
    private final SubjectNameEntity name;
    private final Integer rate;

    public SubjectEntity(Integer id, SubjectNameEntity name, Integer rate) {
        this.id = id;
        this.name = name;
        this.rate = rate;
    }

    public Integer getId() {
        return id;
    }

    public SubjectNameEntity getName() {
        return name;
    }

    public Integer getRate() {
        return rate;
    }
}
