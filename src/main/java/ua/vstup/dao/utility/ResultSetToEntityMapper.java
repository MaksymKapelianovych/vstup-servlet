package ua.vstup.dao.utility;

import ua.vstup.entity.EntrantEntity;
import ua.vstup.entity.FacultyEntity;
import ua.vstup.entity.RoleEntity;
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
                .withFirstname(resultSet.getString("entrant.firstname"))
                .withLastname(resultSet.getString("entrant.lastname"))
                .withSurname(resultSet.getString("entrant.surname"))
                .withEmail(resultSet.getString("entrant.email"))
                .withCity(resultSet.getString("entrant.city"))
                .withSchool(resultSet.getString("entrant.school"))
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
                .build();
        if(entity.getId() == 0){
            throw new DatabaseInteractionException(ERROR_MESSAGE);
        }
        return entity;
    }
}
