package ua.vstup.dao.impl;

import ua.vstup.annotation.Dao;
import ua.vstup.dao.RequestDao;
import ua.vstup.dao.db.holder.ConnectionHolder;
import ua.vstup.domain.State;
import ua.vstup.entity.RequestEntity;
import ua.vstup.entity.StateEntity;
import ua.vstup.exception.DatabaseInteractionException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static ua.vstup.dao.utility.ResultSetToEntityMapper.extractRequestEntityFromResultSet;

@Dao
public class RequestDaoImpl extends AbstractDao<RequestEntity> implements RequestDao {
    private final String INSERT_QUERY = "INSERT INTO request VALUES(DEFAULT,?,?,?,?,?,?,?,?)";
    private final String UPDATE_QUERY = "UPDATE request SET entrant_id=?, faculty_id=?, first_subject_id=?, second_subject_id=?, third_subject_id=?, statement_id=?, state=?, priority=? WHERE id=?";
    private final String UPDATE_STATE_BY_ID_QUERY = "UPDATE request SET state=? WHERE id=?";
    private final String DELETE_QUERY = "DELETE FROM request WHERE id=?";
    private final String FIND_QUERY = "SELECT * FROM request";
    private final String FIND_BY_ID_QUERY = "SELECT * FROM request WHERE id=?";
    private final String FIND_BY_ENTRANT_ID_QUERY = "SELECT * FROM request WHERE entrant_id=?";
    private final String FIND_BY_ENTRANT_ID_AND_FACULTY_ID_QUERY = "SELECT * FROM request WHERE entrant_id=? and faculty_id=?";
    private final String FIND_BY_STATEMENT_ID_QUERY = "SELECT * FROM request WHERE statement_id=?";

    /**
     * Creates a new dao.
     *
     * @param connectionHolder connection holder
     */
    public RequestDaoImpl(ConnectionHolder connectionHolder) {
        super(connectionHolder);
    }

    @Override
    public Integer save(RequestEntity entity) {
        return save(entity, INSERT_QUERY);
    }

    @Override
    public Optional<RequestEntity> findById(Integer id) {
        return findByParam(id, FIND_BY_ID_QUERY);
    }

    @Override
    public List<RequestEntity> findAllByEntrantId(Integer entrantId) { return findAllByParam(entrantId, FIND_BY_ENTRANT_ID_QUERY); }

    @Override
    public Optional<RequestEntity> findByEntrantIdAndFacultyId(Integer entrantId, Integer facultyId) {
        return findByParams(FIND_BY_ENTRANT_ID_AND_FACULTY_ID_QUERY, entrantId, facultyId);
    }

    @Override
    public List<RequestEntity> findAll() { return findAll(FIND_QUERY); }

    @Override
    public List<RequestEntity> findAllByStatementId(Integer id) {
        return findAllByParam(id, FIND_BY_STATEMENT_ID_QUERY);
    }

    @Override
    public boolean updateStateById(Integer id, StateEntity state) {
        try(PreparedStatement ps = getConnection().prepareStatement(UPDATE_QUERY)){
            ps.setObject(1, state.name());
            ps.setObject(2, id);
            if(ps.executeUpdate() > 0){
                return true;
            }
        }catch (SQLException e){
            throw new DatabaseInteractionException(getMessage(UPDATE_STATE_BY_ID_QUERY), e);
        }
        return false;
    }

    @Override
    public boolean update(RequestEntity entity) {
        return update(entity, UPDATE_QUERY);
    }

    @Override
    public boolean deleteById(Integer id) {
        return delete(id, DELETE_QUERY);
    }

    @Override
    protected RequestEntity extractFromResultSet(ResultSet resultSet) throws SQLException {

        return extractRequestEntityFromResultSet(resultSet);
    }

    @Override
    protected void prepareData(RequestEntity entity, PreparedStatement ps) throws SQLException {
        ps.setObject(1, entity.getEntrantEntityId());
        ps.setObject(2, entity.getFacultyEntityId());
        ps.setObject(3, entity.getFirstSubjectEntityId());
        ps.setObject(4, entity.getSecondSubjectEntityId());
        ps.setObject(5, entity.getThirdSubjectEntityId());
        ps.setObject(6, entity.getStatementEntityId());
        ps.setObject(7, entity.getStateEntity().name());
        ps.setObject(8, entity.getPriority());
    }

    @Override
    protected void prepareDataWithId(RequestEntity entity, PreparedStatement ps) throws SQLException {
        prepareData(entity, ps);
        ps.setObject(9, entity.getId());
    }


}
