package ua.vstup.dao.db.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ua.vstup.dao.RequestDao;
import ua.vstup.dao.db.holder.ConnectionHolder;
import ua.vstup.dao.db.holder.ThreadLocalConnectionHolder;
import ua.vstup.dao.db.manager.DbManager;
import ua.vstup.dao.impl.FacultyDaoImpl;
import ua.vstup.dao.impl.RequestDaoImpl;
import ua.vstup.entity.FacultyEntity;
import ua.vstup.entity.RequestEntity;
import ua.vstup.entity.RequirementEntity;
import ua.vstup.entity.StateEntity;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class RequestDaoImplTest {
    private static String SCHEMA_PATH = "src/test/resources/database/schema.sql";
    private static String DATA_PATH = "src/test/resources/database/data.sql";
    private static String DB_PATH = "properties/test_db";

    private RequestEntity preparedRequestEntity;
    private RequestEntity testRequestEntity;
    private static DbManager manager;
    private static ConnectionHolder connectionHolder;
    private RequestDao requestDao;

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
            requestDao = new RequestDaoImpl(connectionHolder);

            initEntity();
        }catch (Exception e){
            fail();
        }
    }

    @Test
    public void findByIdShouldReturnRequest(){
        Optional<RequestEntity> requestEntity = requestDao.findById(preparedRequestEntity.getId());
        assertTrue(requestEntity.isPresent());
    }

    @Test
    public void findByIdShouldReturnNull(){
        Optional<RequestEntity> requestEntity = requestDao.findById(testRequestEntity.getId());
        assertFalse(requestEntity.isPresent());
    }

    @Test
    public void updateShouldReturnTrue(){
        assertTrue(requestDao.update(preparedRequestEntity));
    }

    @Test
    public void updateShouldReturnFalse(){
        assertFalse(requestDao.update(testRequestEntity));
    }

    @Test
    public void deleteByIdShouldReturnTrue(){
        assertTrue(requestDao.deleteById(preparedRequestEntity.getId()));
    }

    @Test
    public void deleteByIdShouldReturnFalse(){
        assertFalse(requestDao.deleteById(testRequestEntity.getId()));
    }

    @After
    public void close() throws SQLException {
        connectionHolder.remove();
        manager.shutdown();
    }

    private void initEntity(){
        preparedRequestEntity = RequestEntity.builder()
                .withId(1)
                .withEntrantEntityId(2)
                .withFacultyEntityId(1)
                .withFirstSubjectEntityId(13)
                .withSecondSubjectEntityId(14)
                .withThirdSubjectEntityId(15)
                .withStatementEntityId(null)
                .withStateEntity(StateEntity.ACTIVE)
                .build();

        testRequestEntity = RequestEntity.builder()
                .withId(0)
                .withEntrantEntityId(2)
                .withFacultyEntityId(1)
                .withFirstSubjectEntityId(13)
                .withSecondSubjectEntityId(14)
                .withThirdSubjectEntityId(15)
                .withStatementEntityId(null)
                .withStateEntity(StateEntity.ACTIVE)
                .build();
    }
}
