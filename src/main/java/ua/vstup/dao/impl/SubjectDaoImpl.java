package ua.vstup.dao.impl;

import ua.vstup.annotation.Dao;
import ua.vstup.dao.SubjectDao;
import ua.vstup.dao.db.holder.ConnectionHolder;
import ua.vstup.entity.SubjectEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static ua.vstup.dao.utility.ResultSetToEntityMapper.extractSubjectEntityFromResultSet;

@Dao
public class SubjectDaoImpl extends AbstractDao<SubjectEntity> implements SubjectDao {
    private static final String INSERT_QUERY = "INSERT INTO subject VALUES (DEFAULT,?,?)";
    private static final String UPDATE_QUERY = "UPDATE subject SET id=?, name=?, rate=? WHERE id=?";
    //private static final String DELETE_QUERY = "DELETE FROM subject WHERE id=?";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM subject WHERE id=?";

    /**
     * Creates a new dao.
     *
     * @param connectionHolder connection holder
     */
    public SubjectDaoImpl(ConnectionHolder connectionHolder) {
        super(connectionHolder);
    }

    @Override
    public Integer save(SubjectEntity entity) {
        return save(entity, INSERT_QUERY);
    }

    @Override
    public Optional<SubjectEntity> findById(Integer id) {
        return findByParam(id, FIND_BY_ID_QUERY);
    }

    @Override
    public boolean update(SubjectEntity entity) {
        return update(entity, UPDATE_QUERY);
    }

    @Override
    public boolean deleteById(Integer id) { throw new UnsupportedOperationException("delete.by.id.for.subject.unsupported"); }

    @Override
    protected SubjectEntity extractFromResultSet(ResultSet resultSet) throws SQLException {
        return extractSubjectEntityFromResultSet(resultSet);
    }

    @Override
    protected void prepareData(SubjectEntity entity, PreparedStatement ps) throws SQLException {
        ps.setObject(1, entity.getId());
        ps.setObject(2, entity.getName().name());
        ps.setObject(3, entity.getRate());
    }

    @Override
    protected void prepareDataWithId(SubjectEntity entity, PreparedStatement ps) throws SQLException {
        prepareData(entity, ps);
        ps.setObject(4, entity.getId());
    }
}
