package ua.vstup.dao.impl;

import ua.vstup.dao.FacultyDao;
import ua.vstup.dao.db.holder.ConnectionHolder;
import ua.vstup.entity.FacultyEntity;
import ua.vstup.entity.FacultyRequirementEntity;
import ua.vstup.exception.DatabaseInteractionException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static ua.vstup.dao.utility.ResultSetToEntityMapper.extractFacultyEntityFromResultSet;


public class FacultyDaoImpl extends AbstractDao<FacultyEntity> implements FacultyDao {
    //TODO переписати запити
    private static final String INSERT_QUERY = "INSERT INTO faculty VALUES (DEFAULT,?,?,?,?)";
    private static final String DELETE_QUERY = "DELETE FROM faculty WHERE id=?";
    private static final String UPDATE_QUERY = "UPDATE faculty SET id=?, name=?, maxBudgetPlace=?, maxPlace=?, facultyRequirement_id=? WHERE id=?";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM faculty JOIN faculty_requirement ON faculty.facultyRequirement_id = faculty_requirement.id WHERE faculty.id=?";

    public static final String INSERT_REQUIREMENTS_QUERY = "INSERT INTO faculty_requirement VALUES (DEFAULT,?,?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE_REQUIREMENTS_QUERY = "UPDATE faculty_requirement SET id=?, firstSubject=?, firstRate=?, secondSubject=?, secondRate=?, thirdSubject=?, thirdRate=?, fourthSubject=?, fourthRate=?, fifthSubject=?, fifthRate=? WHERE id=?";


    public FacultyDaoImpl(ConnectionHolder connectionHolder) { super(connectionHolder); }

    @Override
    public Integer save(FacultyEntity entity) { return save(entity, INSERT_QUERY); } //TODO save faculty requirements

    @Override
    public Optional<FacultyEntity> findById(Integer id) { return findByParam(id, FIND_BY_ID_QUERY); }

    @Override
    public boolean update(FacultyEntity entity) {
        try(PreparedStatement ps = getConnection().prepareStatement(UPDATE_REQUIREMENTS_QUERY)){
            prepareDatawithId(entity.getFacultyRequirementEntity(), ps);
            ps.executeUpdate();
            return update(entity, UPDATE_QUERY);
        }catch(SQLException e){
            LOGGER.warn(String.format(ERROR_MESSAGE, UPDATE_REQUIREMENTS_QUERY, e));
            throw new DatabaseInteractionException(getMessage(UPDATE_REQUIREMENTS_QUERY), e);
        }
    }

    @Override
    public boolean deleteById(Integer id) { return delete(id, DELETE_QUERY); }

    @Override
    protected FacultyEntity extractFromResultSet(ResultSet resultSet) throws SQLException {
        return extractFacultyEntityFromResultSet(resultSet);
    }

    @Override
    protected void prepareData(FacultyEntity entity, PreparedStatement ps) throws SQLException {
        ps.setObject(1, entity.getId());
        ps.setObject(2, entity.getName());
        ps.setObject(3, entity.getMaxBudgetPlace());
        ps.setObject(4, entity.getMaxPlace());
        ps.setObject(5, entity.getFacultyRequirementEntity().getId());
    }

    @Override
    protected void prepareDataWithId(FacultyEntity entity, PreparedStatement ps) throws SQLException {
        prepareData(entity, ps);
        ps.setObject(6, entity.getId());
    }

    private void prepareData(FacultyRequirementEntity entity, PreparedStatement ps) throws SQLException {
        ps.setObject(1, entity.getId());
        ps.setObject(2, entity.getFirstSubject().name());
        ps.setObject(3, entity.getFirstRate());
        ps.setObject(4, entity.getSecondSubject().name());
        ps.setObject(5, entity.getSecondRate());
        ps.setObject(6, entity.getThirdSubject().name());
        ps.setObject(7, entity.getThirdRate());
        ps.setObject(8, entity.getFourthSubject().name());
        ps.setObject(9, entity.getFourthRate());
        ps.setObject(10, entity.getFifthSubject().name());
        ps.setObject(11, entity.getFifthRate());
    }

    private void prepareDatawithId(FacultyRequirementEntity entity, PreparedStatement ps) throws SQLException {
        prepareData(entity, ps);
        ps.setObject(12, entity.getId());
    }
}
