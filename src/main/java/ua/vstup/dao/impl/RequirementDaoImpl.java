package ua.vstup.dao.impl;

import ua.vstup.annotation.Dao;
import ua.vstup.dao.RequirementDao;
import ua.vstup.dao.db.holder.ConnectionHolder;
import ua.vstup.entity.RequirementEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static ua.vstup.dao.utility.ResultSetToEntityMapper.extractRequirementEntityFromResultSet;

@Dao
public class RequirementDaoImpl extends AbstractDao<RequirementEntity> implements RequirementDao {
    private static String INSERT_QUERY = "INSERT INTO requirement VALUES(DEFAULT,?,?,?,?,?)";
    private static String UPDATE_QUERY = "UPDATE requirement SET id=?, first_subject_id=?, second_subject_id=?, third_subject_id=?, fourth_subject_id=?, fifth_subject_id=? WHERE id=?";
    //private static String DELETE_QUERY = "DELETE FROM requirement WHERE id=?";
    private static String FIND_BY_ID_QUERY = "SELECT * FROM requirement WHERE id=?";

    /**
     * Creates a new dao.
     *
     * @param connectionHolder connection holder
     */
    public RequirementDaoImpl(ConnectionHolder connectionHolder) {
        super(connectionHolder);
    }

    @Override
    public Integer save(RequirementEntity entity) {
        return save(entity, INSERT_QUERY);
    }

    @Override
    public Optional<RequirementEntity> findById(Integer id) {
        return findByParam(id, FIND_BY_ID_QUERY);
    }

    @Override
    public boolean update(RequirementEntity entity) {
        return update(entity, UPDATE_QUERY);
    }

    @Override
    public boolean deleteById(Integer id) { throw new UnsupportedOperationException("delete.by.id.for.requirement.unsupported"); }

    @Override
    protected RequirementEntity extractFromResultSet(ResultSet resultSet) throws SQLException {
        return extractRequirementEntityFromResultSet(resultSet);
    }

    @Override
    protected void prepareData(RequirementEntity entity, PreparedStatement ps) throws SQLException {
        ps.setObject(1, entity.getId());
        ps.setObject(2, entity.getFirstSubjectId());
        ps.setObject(3, entity.getSecondSubjectId());
        ps.setObject(4, entity.getThirdSubjectId());
        ps.setObject(5, entity.getFourthSubjectId());
        ps.setObject(6, entity.getFifthSubjectId());
    }

    @Override
    protected void prepareDataWithId(RequirementEntity entity, PreparedStatement ps) throws SQLException {
        prepareData(entity, ps);
        ps.setObject(7, entity.getId());
    }
}
