package ua.vstup.dao.impl;

import ua.vstup.dao.EntrantDao;
import ua.vstup.dao.db.holder.ConnectionHolder;
import ua.vstup.entity.EntrantEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class EntrantDaoImpl extends AbstractDao<EntrantEntity> implements EntrantDao {
    public static final String INSERT_QUERY = "INSERT INTO entrant VALUES (DEFAULT,?,?,?,?,?,?,?)"; //TODO add region
    public static final String DELETE_QUERY = "DELETE FROM entrant WHERE id=?";
    public static final String UPDATE_QUERY = "UPDATE entrant SET id=?, firstname=?, lastname=?, surname=?, email=?, city=?, school=?, role=? WHERE id=?"; //TODO add region
    public static final String FIND_BY_ID_QUERY = "SELECT * FROM entrant WHERE id=?";

    public EntrantDaoImpl(ConnectionHolder connectionHolder) { super(connectionHolder); }

    @Override
    public Integer save(EntrantEntity entity) { return save(entity, INSERT_QUERY); }

    @Override
    public Optional<EntrantEntity> findById(Integer id) { return findByParam(id, FIND_BY_ID_QUERY); }

    @Override
    public boolean update(EntrantEntity entity) { return update(entity, UPDATE_QUERY); }

    @Override
    public boolean deleteById(Integer id) { return delete(id, DELETE_QUERY); }

    @Override
    protected EntrantEntity extractFromResultSet(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected void prepareData(EntrantEntity entity, PreparedStatement ps) throws SQLException {
        ps.setObject(1, entity.getId());
        ps.setObject(2, entity.getFirstname());
        ps.setObject(3, entity.getLastname());
        ps.setObject(4, entity.getSurname());
        ps.setObject(5, entity.getEmail());
        ps.setObject(6, entity.getCity());
        ps.setObject(7, entity.getSchool());
        ps.setObject(8, entity.getRoleEntity().name());
    }

    @Override
    protected void prepareDataWithId(EntrantEntity entity, PreparedStatement ps) throws SQLException {
        prepareData(entity, ps);
        ps.setObject(9, entity.getId());
    }
}
