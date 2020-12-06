package ua.vstup.dao.impl;

import ua.vstup.dao.FacultyDao;
import ua.vstup.dao.RequirementDao;
import ua.vstup.dao.db.holder.ConnectionHolder;
import ua.vstup.entity.FacultyEntity;
import ua.vstup.entity.RequirementEntity;
import ua.vstup.exception.DatabaseInteractionException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static ua.vstup.dao.utility.ResultSetToEntityMapper.extractFacultyEntityFromResultSet;


public class FacultyDaoImpl extends AbstractDao<FacultyEntity> implements FacultyDao {
    //TODO переписати запити
    private static final String INSERT_QUERY = "INSERT INTO faculty VALUES (DEFAULT,?,?,?,?)";
    private static final String DELETE_QUERY = "DELETE FROM faculty WHERE id=?";
    private static final String UPDATE_QUERY = "UPDATE faculty SET id=?, name=?, maxBudgetPlace=?, maxPlace=?, requirement_id=? WHERE id=?";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM faculty WHERE id=?";

    private RequirementDao requirementDao;

    public FacultyDaoImpl(ConnectionHolder connectionHolder) { super(connectionHolder); }

    @Override
    public Integer save(FacultyEntity entity) { return save(entity, INSERT_QUERY); } //TODO save faculty requirements

    @Override
    public Optional<FacultyEntity> findById(Integer id) { return findByParam(id, FIND_BY_ID_QUERY); }

    @Override
    public boolean update(FacultyEntity entity) {
        requirementDao.update(entity.getFacultyRequirementEntity());
        return update(entity, UPDATE_QUERY);
    }

    @Override
    public boolean deleteById(Integer id) { return delete(id, DELETE_QUERY); }

    @Override
    protected FacultyEntity extractFromResultSet(ResultSet resultSet) throws SQLException {
        return extractFacultyEntityFromResultSet(resultSet);
    }

    @Override
    protected void prepareData(FacultyEntity entity, PreparedStatement ps) throws SQLException {
        ps.setObject(1, entity.getId());
        ps.setObject(2, entity.getName());
        ps.setObject(3, entity.getMaxBudgetPlace());
        ps.setObject(4, entity.getMaxPlace());
        ps.setObject(5, entity.getFacultyRequirementEntity().getId());
    }

    @Override
    protected void prepareDataWithId(FacultyEntity entity, PreparedStatement ps) throws SQLException {
        prepareData(entity, ps);
        ps.setObject(6, entity.getId());
    }
}
