package ua.vstup.entity;

public class StatementEntity {
    private Integer id;
    private Boolean finalized;

    public StatementEntity(Integer id, Boolean finalized){
        this.id = id;
        this.finalized = finalized;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getFinalized() {
        return finalized;
    }

    public void setFinalized(boolean b) {
        finalized = b;
    }
}
