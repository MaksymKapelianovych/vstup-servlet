package ua.vstup.dao;

import ua.vstup.domain.Faculty;
import ua.vstup.entity.FacultyEntity;

import java.util.List;


public interface FacultyDao extends BaseDao<FacultyEntity> {
    List<FacultyEntity> findAll();

    boolean updateActiveById(Integer id, boolean active);

    List<FacultyEntity> findAllByActive(boolean active);
}
