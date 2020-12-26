package ua.vstup.dao.utility;

import ua.vstup.entity.*;
import ua.vstup.exception.DatabaseInteractionException;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Utility class , converts values from {@link ResultSet} to specified entity
 */
public class ResultSetToEntityMapper {
    private static final String ERROR_MESSAGE = "Cannot extract entity from result set";

    private ResultSetToEntityMapper(){}

    public static EntrantEntity extractEntrantEntityFromResultSet(ResultSet resultSet) throws SQLException {
        EntrantEntity entity = EntrantEntity.builder()
                .withId(resultSet.getInt("entrant.id"))
                .withName(resultSet.getString("entrant.name"))
                .withPassword(resultSet.getString("entrant.password"))
                .withEmail(resultSet.getString("entrant.email"))
                .withSchoolEntityId(resultSet.getInt("entrant.school_id"))
                .withRoleEntity(RoleEntity.valueOf(resultSet.getString("entrant.role")))
                .withRequirementEntityId(resultSet.getInt("entrant.requirement_id"))
                .withActive(resultSet.getBoolean("entrant.active"))
                .build();
        if(entity.getId() == 0){
            throw new DatabaseInteractionException(ERROR_MESSAGE);
        }
        return entity;
    }

    public static FacultyEntity extractFacultyEntityFromResultSet(ResultSet resultSet) throws SQLException {
        FacultyEntity entity = FacultyEntity.builder()
                .withId(resultSet.getInt("faculty.id"))
                .withNameUa(resultSet.getString("faculty.name_ua"))
                .withNameEn(resultSet.getString("faculty.name_en"))
                .withMaxBudgetPlace(resultSet.getInt("faculty.maxBudgetPlace"))
                .withMaxPlace(resultSet.getInt("faculty.maxPlace"))
                .withRequirementEntityId(resultSet.getInt("faculty.requirement_id"))
                .withActive(resultSet.getBoolean("faculty.active"))
                .build();
        if(entity.getId() == 0){
            throw new DatabaseInteractionException(ERROR_MESSAGE);
        }
        return entity;
    }

    public static RequirementEntity extractRequirementEntityFromResultSet(ResultSet resultSet) throws SQLException {
        RequirementEntity entity = RequirementEntity.builder()
                .withId(resultSet.getInt("requirement.id"))
                .withFirstSubjectId(resultSet.getInt("requirement.first_subject_id"))
                .withSecondSubjectId(resultSet.getInt("requirement.second_subject_id"))
                .withThirdSubjectId(resultSet.getInt("requirement.third_subject_id"))
                .withFourthSubjectId(resultSet.getInt("requirement.fourth_subject_id"))
                .withFifthSubjectId(resultSet.getInt("requirement.fifth_subject_id"))
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
                .withNameUa(resultSet.getString("school.name_ua"))
                .withNameEn(resultSet.getString("school.name_en"))
                .withCityUa(resultSet.getString("school.city_ua"))
                .withCityEn(resultSet.getString("school.city_en"))
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
                .withEntrantEntityId(resultSet.getInt("request.entrant_id"))
                .withFacultyEntityId(resultSet.getInt("request.faculty_id"))
                .withFirstSubjectEntityId(resultSet.getInt("request.first_subject_id"))
                .withSecondSubjectEntityId(resultSet.getInt("request.second_subject_id"))
                .withThirdSubjectEntityId(resultSet.getInt("request.third_subject_id"))
                .withStatementEntityId(resultSet.getInt("request.statement_id"))
                .withPriority(resultSet.getInt("request.priority"))
                .withStateEntity(StateEntity.valueOf(resultSet.getString("request.state")))
                .build();
        if(entity.getId() == 0){
            throw new DatabaseInteractionException(ERROR_MESSAGE);
        }
        return entity;
    }

    public static StatementEntity extractStatementEntityFromResultSet(ResultSet resultSet) throws SQLException {
        StatementEntity entity = new StatementEntity(resultSet.getInt("statement.id"), resultSet.getBoolean("statement.finalized"));
        if(entity.getId() == 0){
            throw new DatabaseInteractionException(ERROR_MESSAGE);
        }
        return entity;
    }
}
