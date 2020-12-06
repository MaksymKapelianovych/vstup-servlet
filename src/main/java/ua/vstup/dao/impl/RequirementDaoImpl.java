package ua.vstup.dao.impl;

import ua.vstup.dao.RequirementDao;
import ua.vstup.dao.SubjectDao;
import ua.vstup.dao.db.holder.ConnectionHolder;
import ua.vstup.entity.RequirementEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static ua.vstup.dao.utility.ResultSetToEntityMapper.extractRequirementEntityFromResultSet;

public class RequirementDaoImpl extends AbstractDao<RequirementEntity> implements RequirementDao {
    private static String INSERT_QUERY = "INSERT INTO requirement VALUES(DEFAULT,?,?,?,?,?)";
    private static String UPDATE_QUERY = "UPDATE requirement SET id=?, first_subject_id=?, second_subject_id=?, third_subject_id=?, fourth_subject_id=?, fifth_subject_id=? WHERE id=?";
    private static String DELETE_QUERY = "DELETE FROM requirement WHERE id=?";
    private static String FIND_BY_ID_QUERY = "SELECT * FROM requirement WHERE id=?";

    private SubjectDao subjectDao;

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
        subjectDao.save(entity.getFirstSubject());
        subjectDao.save(entity.getSecondSubject());
        subjectDao.save(entity.getThirdSubject());
        subjectDao.save(entity.getFourthSubject());
        subjectDao.save(entity.getFifthSubject());
        return save(entity, INSERT_QUERY);
    }

    @Override
    public Optional<RequirementEntity> findById(Integer id) {
        return findByParam(id, FIND_BY_ID_QUERY);
    }

    @Override
    public boolean update(RequirementEntity entity) {
        subjectDao.update(entity.getFirstSubject());
        subjectDao.update(entity.getSecondSubject());
        subjectDao.update(entity.getThirdSubject());
        subjectDao.update(entity.getFourthSubject());
        subjectDao.update(entity.getFifthSubject());
        return update(entity, UPDATE_QUERY);
    }

    @Override
    public boolean deleteById(Integer id) {
        return delete(id, DELETE_QUERY);
    }

    @Override
    protected RequirementEntity extractFromResultSet(ResultSet resultSet) throws SQLException {
        return extractRequirementEntityFromResultSet(resultSet);
    }

    @Override
    protected void prepareData(RequirementEntity entity, PreparedStatement ps) throws SQLException {
        ps.setObject(1, entity.getId());
        ps.setObject(2, entity.getFirstSubject().getId());
        ps.setObject(3, entity.getSecondSubject().getId());
        ps.setObject(4, entity.getThirdSubject().getId());
        ps.setObject(5, entity.getFourthSubject().getId());
        ps.setObject(6, entity.getFifthSubject().getId());
    }

    @Override
    protected void prepareDataWithId(RequirementEntity entity, PreparedStatement ps) throws SQLException {
        prepareData(entity, ps);
        ps.setObject(7, entity.getId());
    }
}
