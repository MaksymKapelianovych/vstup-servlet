package ua.vstup.dao.impl;

import ua.vstup.annotation.Dao;
import ua.vstup.dao.SchoolDao;
import ua.vstup.dao.db.holder.ConnectionHolder;
import ua.vstup.entity.SchoolEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static ua.vstup.dao.utility.ResultSetToEntityMapper.extractSchoolEntityFromResultSet;

@Dao
public class SchoolDaoImpl extends AbstractDao<SchoolEntity> implements SchoolDao {
    private static final String INSERT_QUERY = "INSERT INTO school VALUES (DEFAULT,?,?,?,?,?)";
    private static final String UPDATE_QUERY = "UPDATE school SET name_ua=?, name_en=?, city_ua=?, city_en=?, region=? WHERE id=?";
    private static final String DELETE_QUERY = "DELETE FROM school WHERE id=?";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM school WHERE id=?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM school";
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
    public List<SchoolEntity> findAll() {
        return findAll(FIND_ALL_QUERY);
    }

    @Override
    public boolean update(SchoolEntity entity) {
        return update(entity, UPDATE_QUERY);
    }

    @Override
    public boolean deleteById(Integer id) { throw new UnsupportedOperationException("delete.by.id.for.school.unsupported"); }

    @Override
    protected SchoolEntity extractFromResultSet(ResultSet resultSet) throws SQLException {
        return extractSchoolEntityFromResultSet(resultSet);
    }

    @Override
    protected void prepareData(SchoolEntity entity, PreparedStatement ps) throws SQLException {
        ps.setObject(1, entity.getName_ua());
        ps.setObject(2, entity.getName_en());
        ps.setObject(3, entity.getCity_ua());
        ps.setObject(4, entity.getCity_en());
        ps.setObject(5, entity.getRegionEntity().name());
    }

    @Override
    protected void prepareDataWithId(SchoolEntity entity, PreparedStatement ps) throws SQLException {
        prepareData(entity, ps);
        ps.setObject(6, entity.getId());
    }

}
