package ua.vstup.dao.impl;

import ua.vstup.annotation.Dao;
import ua.vstup.dao.EntrantDao;
import ua.vstup.dao.db.holder.ConnectionHolder;
import ua.vstup.entity.EntrantEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static ua.vstup.dao.utility.ResultSetToEntityMapper.extractEntrantEntityFromResultSet;

@Dao
public class EntrantDaoImpl extends AbstractDao<EntrantEntity> implements EntrantDao {
    private static final String INSERT_QUERY = "INSERT INTO entrant VALUES (DEFAULT,?,?,?,?,?,?,?)"; //TODO add region
    //private static final String DELETE_QUERY = "DELETE FROM entrant WHERE id=?";
    private static final String UPDATE_QUERY = "UPDATE entrant SET id=?, name=?, password=?, email=?, school_id=?, role=?, requirement_id=?, active=? WHERE id=?"; //TODO add region
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM entrant WHERE id=?";

    public EntrantDaoImpl(ConnectionHolder connectionHolder) { super(connectionHolder); }

    @Override
    public Integer save(EntrantEntity entity) { return save(entity, INSERT_QUERY); }

    @Override
    public Optional<EntrantEntity> findById(Integer id) { return findByParam(id, FIND_BY_ID_QUERY); }

    @Override
    public boolean update(EntrantEntity entity) { return update(entity, UPDATE_QUERY); }

    @Override
    public boolean deleteById(Integer id) { throw new UnsupportedOperationException("delete.by.id.for.entrant.unsupported");}

    @Override
    protected EntrantEntity extractFromResultSet(ResultSet resultSet) throws SQLException {
        return extractEntrantEntityFromResultSet(resultSet);
    }

    //TODO
    @Override
    protected void prepareData(EntrantEntity entity, PreparedStatement ps) throws SQLException {
        ps.setObject(1, entity.getId());
        ps.setObject(2, entity.getName());
        ps.setObject(3, entity.getPassword());
        ps.setObject(4, entity.getEmail());
        ps.setObject(5, entity.getSchoolEntityId());
        ps.setObject(6, entity.getRoleEntity().name());
        ps.setObject(7, entity.getRequirementEntityId());
        ps.setObject(8, entity.getActive());
    }

    @Override
    protected void prepareDataWithId(EntrantEntity entity, PreparedStatement ps) throws SQLException {
        prepareData(entity, ps);
        ps.setObject(9, entity.getId());
    }
}
