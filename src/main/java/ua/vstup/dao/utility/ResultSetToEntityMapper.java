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
                .withFullname(resultSet.getString("entrant.firstname"))
                .withEmail(resultSet.getString("entrant.email"))
                .withSchoolEntity(extractSchoolEntityFromResultSet(resultSet))
                .withRoleEntity(RoleEntity.valueOf(resultSet.getString("entrant.role")))
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
                .withFacultyRequirementEntity(extractFacultyRequirementEntityFromResultSet(resultSet))
                .build();
        if(entity.getId() == 0){
            throw new DatabaseInteractionException(ERROR_MESSAGE);
        }
        return entity;
    }

    public static FacultyRequirementEntity extractFacultyRequirementEntityFromResultSet(ResultSet resultSet) throws SQLException {
        FacultyRequirementEntity entity = FacultyRequirementEntity.builder()
                .withId(resultSet.getInt("facultyRequirement.id"))
                .withFirstSubject(SubjectEntity.valueOf(resultSet.getString("facultyRequirement.firstSubject")))
                .withFirstRate(resultSet.getInt("facultyRequirement.firstRate"))
                .withSecondSubject(SubjectEntity.valueOf(resultSet.getString("facultyRequirement..secondSubject")))
                .withSecondRate(resultSet.getInt("facultyRequirement.secondRate"))
                .withThirdSubject(SubjectEntity.valueOf(resultSet.getString("facultyRequirement.thirdSubject")))
                .withThirdRate(resultSet.getInt("facultyRequirement.thirdRate"))
                .build();
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
}
