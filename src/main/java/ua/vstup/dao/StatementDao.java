package ua.vstup.dao;

import ua.vstup.entity.StatementEntity;

import java.util.Optional;

public interface StatementDao extends BaseDao<StatementEntity>{
    Optional<StatementEntity> findByFinalized(boolean finalized);
}
