package ua.vstup.dao.impl;

import ua.vstup.annotation.Dao;
import ua.vstup.dao.StatementDao;
import ua.vstup.dao.db.holder.ConnectionHolder;
import ua.vstup.entity.StatementEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static ua.vstup.dao.utility.ResultSetToEntityMapper.extractStatementEntityFromResultSet;

@Dao
public class StatementDaoImpl extends AbstractDao<StatementEntity> implements StatementDao {
    private static String FIND_BY_FINALIZED_QUERY = "SELECT * FROM statement WHERE finalized=?";
    private static String FIND_BY_ID_QUERY = "SELECT * FROM statement WHERE id=?";
    private static String INSERT_QUERY = "INSERT INTO statement VALUES(DEFAULT,?)";
    private static String UPDATE_QUERY = "UPDATE statement SET finalized=? WHERE id=?";

    /**
     * Creates a new dao.
     *
     * @param connectionHolder connection holder
     */
    public StatementDaoImpl(ConnectionHolder connectionHolder) { super(connectionHolder); }

    @Override
    public Integer save(StatementEntity entity) { return save(entity, INSERT_QUERY); }

    @Override
    public Optional<StatementEntity> findById(Integer id) { return findByParam(id, FIND_BY_ID_QUERY); }

    @Override
    public Optional<StatementEntity> findByFinalized(boolean finalized) { return findByParam(finalized, FIND_BY_FINALIZED_QUERY); }

    @Override
    public boolean update(StatementEntity entity) { return update(entity, UPDATE_QUERY); }

    @Override
    public boolean deleteById(Integer id) { throw new UnsupportedOperationException("delete.by.id.for.statement.not.supported"); }

    @Override
    protected StatementEntity extractFromResultSet(ResultSet resultSet) throws SQLException {
        return extractStatementEntityFromResultSet(resultSet);
    }

    @Override
    protected void prepareData(StatementEntity entity, PreparedStatement ps) throws SQLException {
        ps.setObject(1, entity.getFinalized());
    }

    @Override
    protected void prepareDataWithId(StatementEntity entity, PreparedStatement ps) throws SQLException {
        prepareData(entity, ps);
        ps.setObject(2, entity.getId());
    }

}
