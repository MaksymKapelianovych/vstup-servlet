package ua.vstup.dao;

import ua.vstup.domain.School;
import ua.vstup.entity.SchoolEntity;

import java.util.List;

public interface SchoolDao extends BaseDao<SchoolEntity> {
    List<SchoolEntity> findAll();
}
