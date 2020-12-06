package ua.vstup.dao.impl;

import ua.vstup.dao.RequestDao;
import ua.vstup.dao.SubjectDao;
import ua.vstup.dao.db.holder.ConnectionHolder;
import ua.vstup.entity.RequestEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static ua.vstup.dao.utility.ResultSetToEntityMapper.extractRequestEntityFromResultSet;

public class RequestDaoImpl extends AbstractDao<RequestEntity> implements RequestDao {
    private final String INSERT_QUERY = "INSERT INTO request VALUES(DEFAULT,?,?,?,?,?,?,?)";
    private final String UPDATE_QUERY = "UPDATE request SET id=?, entrant_id=?, faculty_id=?, first_subject_id=?, second_subject_id=?, third_subject_id=?, statement_id=?, state=? WHERE id=?";
    private final String DELETE_QUERY = "DELETE FROM request WHERE id=?";
    private final String FIND_BY_ID_QUERY = "SELECT * FROM request WHERE id=?";

    private SubjectDao subjectDao;

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
        ps.setObject(1, entity.getId());
        ps.setObject(2, entity.getEntrantEntityId());
        ps.setObject(3, entity.getFacultyEntityId());
        ps.setObject(4, entity.getFirstSubjectEntityId());
        ps.setObject(5, entity.getSecondSubjectEntityId());
        ps.setObject(6, entity.getThirdSubjectEntityId());
        ps.setObject(7, entity.getStatementEntityId());
        ps.setObject(8, entity.getStateEntity().name());
    }

    @Override
    protected void prepareDataWithId(RequestEntity entity, PreparedStatement ps) throws SQLException {
        prepareData(entity, ps);
        ps.setObject(9, entity.getId());
    }
}
