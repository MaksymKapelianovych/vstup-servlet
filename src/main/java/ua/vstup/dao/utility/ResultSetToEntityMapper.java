package ua.vstup.dao.utility;

import org.omg.PortableInterceptor.RequestInfoOperations;
import ua.vstup.dao.RequirementDao;
import ua.vstup.dao.SchoolDao;
import ua.vstup.dao.SubjectDao;
import ua.vstup.dao.impl.SubjectDaoImpl;
import ua.vstup.entity.*;
import ua.vstup.exception.DatabaseInteractionException;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Utility class , converts values from {@link ResultSet} to specified entity
 */
public class ResultSetToEntityMapper {
    private static final String ERROR_MESSAGE = "Cannot extract entity from result set";

    private static SubjectDao subjectDao;
    private static RequirementDao requirementDao;
    private static SchoolDao schoolDao;

    private ResultSetToEntityMapper(){}

    public static EntrantEntity extractEntrantEntityFromResultSet(ResultSet resultSet) throws SQLException {
        EntrantEntity entity = EntrantEntity.builder()
                .withId(resultSet.getInt("entrant.id"))
                .withName(resultSet.getString("entrant.name"))
                .withPassword(resultSet.getString("entrant.password"))
                .withEmail(resultSet.getString("entrant.email"))
                .withSchoolEntity(schoolDao.findById(resultSet.getInt("entrant.school_id")).get())
                .withRoleEntity(RoleEntity.valueOf(resultSet.getString("entrant.role")))
                .withRequirementEntity(requirementDao.findById(resultSet.getInt("entrant.requirement_id")).get())
                .build();
        if(entity.getId() == 0){
            throw new DatabaseInteractionException(ERROR_MESSAGE);
        }
        return entity;
    }

    public static FacultyEntity extractFacultyEntityFromResultSet(ResultSet resultSet) throws SQLException {
        FacultyEntity entity = FacultyEntity.builder()
                .withId(resultSet.getInt("faculty.id"))
                .withName(resultSet.getString("faculty.name"))
                .withMaxBudgetPlace(resultSet.getInt("faculty.maxBudgetPlace"))
                .withMaxPlace(resultSet.getInt("faculty.maxPlace"))
                .withRequirementEntity(requirementDao.findById(resultSet.getInt("faculty.requirement_id")).get())
                .build();
        if(entity.getId() == 0){
            throw new DatabaseInteractionException(ERROR_MESSAGE);
        }
        return entity;
    }

    public static RequirementEntity extractRequirementEntityFromResultSet(ResultSet resultSet) throws SQLException {
        RequirementEntity entity = RequirementEntity.builder()
                .withId(resultSet.getInt("requirement.id"))
                .withFirstSubject(subjectDao.findById(resultSet.getInt("requirement.first_subject_id")).get())
                .withSecondSubject(subjectDao.findById(resultSet.getInt("requirement.second_subject_id")).get())
                .withThirdSubject(subjectDao.findById(resultSet.getInt("requirement.third_subject_id")).get())
                .withFourthSubject(subjectDao.findById(resultSet.getInt("requirement.fourth_subject_id")).get())
                .withFifthSubject(subjectDao.findById(resultSet.getInt("requirement.fifth_subject_id")).get())
                .build();
        if(entity.getId() == 0){
            throw new DatabaseInteractionException(ERROR_MESSAGE);
        }
        return entity;
    }

    public static SubjectEntity extractSubjectEntityFromResultSet(ResultSet resultSet) throws SQLException {
        SubjectEntity entity = new SubjectEntity(
                resultSet.getInt("subject.id"),
                SubjectNameEntity.valueOf(resultSet.getString("subject.name")),
                resultSet.getInt("subject.rate"));
        if(entity.getId() == 0){
            throw new DatabaseInteractionException(ERROR_MESSAGE);
        }
        return entity;
    }

    public static SchoolEntity extractSchoolEntityFromResultSet(ResultSet resultSet) throws SQLException {
        SchoolEntity entity = SchoolEntity.builder()
                .withId(resultSet.getInt("school.id"))
                .withName(resultSet.getString("school.name"))
                .withCity(resultSet.getString("school.city"))
                .withRegionEntity(RegionEntity.valueOf(resultSet.getString("school.region")))
                .build();
        if(entity.getId() == 0){
            throw new DatabaseInteractionException(ERROR_MESSAGE);
        }
        return entity;
    }

    public static RequestEntity extractRequestEntityFromResultSet(ResultSet resultSet) throws SQLException {
        RequestEntity entity = RequestEntity.builder()
                .withId(resultSet.getInt("request.id"))
                .withEntrantId(resultSet.getInt("request.entrant_id"))
                .withFacultyId(resultSet.getInt("request.faculty_id"))
                .withFirstSubjectEntity(subjectDao.findById(resultSet.getInt("request.first_subject_id")).get())
                .withSecondSubjectEntity(subjectDao.findById(resultSet.getInt("request.second_subject_id")).get())
                .withThirdSubjectEntity(subjectDao.findById(resultSet.getInt("request.third_subject_id")).get())
                .withStatementId(resultSet.getInt("request.statement_id"))
                .withStateEntity(StateEntity.valueOf(resultSet.getString("request.state")))
                .build();
        if(entity.getId() == 0){
            throw new DatabaseInteractionException(ERROR_MESSAGE);
        }
        return entity;
    }
}
