package ua.vstup.dao;

import ua.vstup.entity.EntrantEntity;

import java.util.Optional;

public interface EntrantDao extends BaseDao<EntrantEntity> {
    Optional<EntrantEntity> findByEmail(String email);
}
