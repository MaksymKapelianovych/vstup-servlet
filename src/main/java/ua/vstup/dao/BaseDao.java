package ua.vstup.dao;

import java.util.Optional;

/**
 * Base dao interface which contain methods crud interaction with DB.
 */
public interface BaseDao<E> {
    Integer save(E entity);

    Optional<E> findById(Integer id);

    boolean update(E entity);

    boolean deleteById(Integer id);
}
