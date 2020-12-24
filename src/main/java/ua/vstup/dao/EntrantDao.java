package ua.vstup.dao;

import ua.vstup.domain.Entrant;
import ua.vstup.entity.EntrantEntity;
import ua.vstup.entity.RoleEntity;

import java.util.List;
import java.util.Optional;

public interface EntrantDao extends BaseDao<EntrantEntity> {
    Optional<EntrantEntity> findByEmail(String email);

    List<EntrantEntity> findAllByRole(RoleEntity roleEntity);

    boolean updateActiveById(Integer id, boolean active);
}
