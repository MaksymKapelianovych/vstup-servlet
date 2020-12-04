package ua.vstup.dao.impl;

import ua.vstup.dao.BaseDao;
import ua.vstup.dao.SchoolDao;
import ua.vstup.dao.db.holder.ConnectionHolder;
import ua.vstup.entity.RegionEntity;
import ua.vstup.entity.SchoolEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static ua.vstup.dao.utility.ResultSetToEntityMapper.extractSchoolEntityFromResultSet;

public class SchoolDaoImpl extends AbstractDao<SchoolEntity> implements SchoolDao {
    public static final String INSERT_QUERY = "INSERT INTO school VALUES (DEFAULT,?,?,?)";
    public static final String UPDATE_QUERY = "UPDATE school SET id=?, name=?, city=?, region=? WHERE id=?";
    public static final String DELETE_QUERY = "DELETE FROM school WHERE id=?";
    public static final String FIND_BY_ID_QUERY = "SELECT * FROM school WHERE id=?";
    /**
     * Creates a new dao.
     *
     * @param connectionHolder connection holder
     */
    public SchoolDaoImpl(ConnectionHolder connectionHolder) {
        super(connectionHolder);
    }

    @Override
    public Integer save(SchoolEntity entity) {
        return save(entity, INSERT_QUERY);
    }

    @Override
    public Optional<SchoolEntity> findById(Integer id) {
        return findByParam(id, FIND_BY_ID_QUERY);
    }

    @Override
    public boolean update(SchoolEntity entity) {
        return update(entity, UPDATE_QUERY);
    }

    @Override
    public boolean deleteById(Integer id) {
        return delete(id, DELETE_QUERY);
    }

    @Override
    protected SchoolEntity extractFromResultSet(ResultSet resultSet) throws SQLException {
        return extractSchoolEntityFromResultSet(resultSet);
    }

    @Override
    protected void prepareData(SchoolEntity entity, PreparedStatement ps) throws SQLException {
        ps.setObject(1, entity.getId());
        ps.setObject(2, entity.getName());
        ps.setObject(3, entity.getCity());
        ps.setObject(4, entity.getRegionEntity().name());
    }

    @Override
    protected void prepareDataWithId(SchoolEntity entity, PreparedStatement ps) throws SQLException {
        prepareData(entity, ps);
        ps.setObject(5, entity.getId());
    }
}
