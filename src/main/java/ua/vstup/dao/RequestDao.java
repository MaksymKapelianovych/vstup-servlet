package ua.vstup.dao;

import ua.vstup.domain.Request;
import ua.vstup.entity.RequestEntity;

import java.util.Arrays;
import java.util.List;

public interface RequestDao extends BaseDao<RequestEntity> {
    List<RequestEntity> findAllByEntrantId(Integer entrantId);

    List<RequestEntity> findAll();
}
