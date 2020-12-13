package ua.vstup.dao;

import ua.vstup.entity.FacultyEntity;

import java.util.List;


public interface FacultyDao extends BaseDao<FacultyEntity> {
    List<FacultyEntity> findAll();
}
