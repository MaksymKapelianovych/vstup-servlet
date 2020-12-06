package ua.vstup.dao.db.impl;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ua.vstup.dao.RequirementDao;
import ua.vstup.dao.db.holder.ConnectionHolder;
import ua.vstup.dao.db.holder.ThreadLocalConnectionHolder;
import ua.vstup.dao.db.manager.DbManager;
import ua.vstup.dao.impl.RequirementDaoImpl;
import ua.vstup.entity.RequirementEntity;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Optional;

import static org.junit.Assert.*;

public class RequirementDaoImplTest {
    private static String SCHEMA_PATH = "src/test/resources/database/schema.sql";
    private static String DATA_PATH = "src/test/resources/database/data.sql";
    private static String DB_PATH = "properties/test_db";

    private static String ERROR_MESSAGE = "delete.by.id.for.requirement.unsupported";

    private RequirementEntity preparedRequirementEntity;
    private RequirementEntity testRequirementEntity;
    private static DbManager manager;
    private static ConnectionHolder connectionHolder;
    private RequirementDao requirementDao;

    @Rule
    public ExpectedException exception = ExpectedException.none();
    @Before
    public void init(){
        try{
            manager = new DbManager(DB_PATH);
            connectionHolder = new ThreadLocalConnectionHolder();

            Connection connection = manager.getConnection();

            Statement statement = connection.createStatement();
            String schemaQuery = new String(Files.readAllBytes(Paths.get(SCHEMA_PATH)));
            statement.execute(schemaQuery);
            String dataQuery = new String(Files.readAllBytes(Paths.get(DATA_PATH)));
            statement.execute(dataQuery);
            statement.close();
            connection.close();

            connectionHolder.set(manager.getConnection());
            requirementDao = new RequirementDaoImpl(connectionHolder);

            initEntity();
        }catch (Exception e){
            fail();
        }
    }

    @Test
    public void findByIdShouldReturnRequirement(){
        Optional<RequirementEntity> requirementEntity = requirementDao.findById(preparedRequirementEntity.getId());
        assertTrue(requirementEntity.isPresent());
    }

    @Test
    public void findByIdShouldReturnNull(){
        Optional<RequirementEntity> requirementEntity = requirementDao.findById(testRequirementEntity.getId());
        assertFalse(requirementEntity.isPresent());
    }

    @Test
    public void updateShouldReturnTrue(){
        assertTrue(requirementDao.update(preparedRequirementEntity));
    }

    @Test
    public void updateShouldReturnFalse(){
        assertFalse(requirementDao.update(testRequirementEntity));
    }

    @Test
    public void deleteShouldThrowUnsupportedOperationException(){
        exception.expect(UnsupportedOperationException.class);
        exception.expectMessage(ERROR_MESSAGE);
        requirementDao.deleteById(preparedRequirementEntity.getId());
    }


    private void initEntity(){
        preparedRequirementEntity = RequirementEntity.builder()
                .withId(2)
                .withFirstSubjectId(6)
                .withSecondSubjectId(7)
                .withThirdSubjectId(8)
                .withFourthSubjectId(9)
                .withFifthSubjectId(null)
                .build();

        testRequirementEntity = RequirementEntity.builder()
                .withId(0)
                .withFirstSubjectId(0)
                .withSecondSubjectId(0)
                .withThirdSubjectId(0)
                .withFourthSubjectId(null)
                .withFifthSubjectId(null)
                .build();
    }
}
