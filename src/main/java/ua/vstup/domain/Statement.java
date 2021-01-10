package ua.vstup.domain;

public class Statement {
    private final Integer id;
    private final Boolean finalized;

    public Statement(Integer id, Boolean finalized){
        this.id = id;
        this.finalized = finalized;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getFinalized() {
        return finalized;
    }
}

