package ua.vstup.dao.impl;

import ua.vstup.annotation.Dao;
import ua.vstup.dao.EntrantDao;
import ua.vstup.dao.db.holder.ConnectionHolder;
import ua.vstup.entity.EntrantEntity;
import ua.vstup.entity.RoleEntity;
import ua.vstup.exception.DatabaseInteractionException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static ua.vstup.dao.utility.ResultSetToEntityMapper.extractEntrantEntityFromResultSet;

@Dao
public class EntrantDaoImpl extends AbstractDao<EntrantEntity> implements EntrantDao {
    private static final String INSERT_QUERY = "INSERT INTO entrant VALUES (DEFAULT,?,?,?,?,?,?,?)"; //TODO add region
    //private static final String DELETE_QUERY = "DELETE FROM entrant WHERE id=?";
    private static final String UPDATE_QUERY = "UPDATE entrant SET name=?, password=?, email=?, school_id=?, role=?, requirement_id=?, active=? WHERE id=?"; //TODO add region
    private static final String UPDATE_ACTIVE_BY_ID_QUERY = "UPDATE entrant SET active=? WHERE id=?";
    private static final String FIND_ALL_BY_ROLE_QUERY = "SELECT * FROM entrant WHERE role=?";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM entrant WHERE id=?";
    private static final String FIND_BY_EMAIL_QUERY = "SELECT * FROM entrant WHERE email=?";

    public EntrantDaoImpl(ConnectionHolder connectionHolder) { super(connectionHolder); }

    @Override
    public Integer save(EntrantEntity entity) {
        return save(entity, INSERT_QUERY);
    }

    @Override
    public Optional<EntrantEntity> findById(Integer id) { return findByParam(id, FIND_BY_ID_QUERY); }

    @Override
    public Optional<EntrantEntity> findByEmail(String email) { return findByParam(email, FIND_BY_EMAIL_QUERY); }

    @Override
    public List<EntrantEntity> findAllByRole(RoleEntity roleEntity) { return findAllByParam(roleEntity.name(), FIND_ALL_BY_ROLE_QUERY); }

    @Override
    public boolean updateActiveById(Integer id, boolean active) {
        try(PreparedStatement ps = getConnection().prepareStatement(UPDATE_ACTIVE_BY_ID_QUERY)){
            ps.setObject(1, active);
            ps.setObject(2, id);
            if(ps.executeUpdate() > 0){
                return true;
            }
        }catch (SQLException e){
            throw new DatabaseInteractionException(getMessage(UPDATE_ACTIVE_BY_ID_QUERY), e);
        }
        return false;
    }

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
        ps.setObject(1, entity.getName());
        ps.setObject(2, entity.getPassword());
        ps.setObject(3, entity.getEmail());
        ps.setObject(4, entity.getSchoolEntityId());
        ps.setObject(5, entity.getRoleEntity().name());
        ps.setObject(6, entity.getRequirementEntityId());
        ps.setObject(7, entity.getActive());
    }

    @Override
    protected void prepareDataWithId(EntrantEntity entity, PreparedStatement ps) throws SQLException {
        prepareData(entity, ps);
        ps.setObject(8, entity.getId());
    }


}
