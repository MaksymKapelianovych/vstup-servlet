package ua.vstup.dao;

import ua.vstup.domain.Request;
import ua.vstup.domain.State;
import ua.vstup.entity.RequestEntity;
import ua.vstup.entity.StateEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface RequestDao extends BaseDao<RequestEntity> {
    List<RequestEntity> findAllByEntrantId(Integer entrantId);

    List<RequestEntity> findAll();

    List<RequestEntity> findAllByStatementId(Integer id);

    boolean updateStateById(Integer id, StateEntity state);

    Optional<RequestEntity> findByEntrantIdAndFacultyId(Integer entrantId, Integer facultyId);
}
