package ua.vstup.dao.db.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ua.vstup.dao.FacultyDao;
import ua.vstup.dao.db.holder.ConnectionHolder;
import ua.vstup.dao.db.holder.ThreadLocalConnectionHolder;
import ua.vstup.dao.db.manager.DbManager;
import ua.vstup.dao.impl.FacultyDaoImpl;
import ua.vstup.entity.FacultyEntity;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import static org.junit.Assert.*;

public class FacultyDaoImplTest {
    private static String SCHEMA_PATH = "src/test/resources/database/schema.sql";
    private static String DATA_PATH = "src/test/resources/database/data.sql";
    private static String DB_PATH = "properties/test_db";

    private static String ERROR_MESSAGE = "delete.by.id.for.faculty.unsupported";

    private FacultyEntity preparedFacultyEntity;
    private FacultyEntity testFacultyEntity;
    private static DbManager manager;
    private static ConnectionHolder connectionHolder;
    private FacultyDao facultyDao;

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
            facultyDao = new FacultyDaoImpl(connectionHolder);

            initEntity();
        }catch (Exception e){
            fail();
        }
    }

    @Test
    public void findByIdShouldReturnFaculty(){
        Optional<FacultyEntity> faculty = facultyDao.findById(preparedFacultyEntity.getId());
        assertTrue(faculty.isPresent());
    }

    @Test
    public void findByIdShouldReturnNull(){
        Optional<FacultyEntity> facultyEntity = facultyDao.findById(testFacultyEntity.getId());
        assertFalse(facultyEntity.isPresent());
    }

    @Test
    public void updateShouldReturnTrue(){
        assertTrue(facultyDao.update(preparedFacultyEntity));
    }

    @Test
    public void updateShouldReturnFalse(){
        assertFalse(facultyDao.update(testFacultyEntity));
    }

    @Test
    public void deleteShouldThrowUnsupportedOperationException(){
        exception.expect(UnsupportedOperationException.class);
        exception.expectMessage(ERROR_MESSAGE);
        facultyDao.deleteById(preparedFacultyEntity.getId());
    }

    @After
    public void close() throws SQLException {
        connectionHolder.remove();
        manager.shutdown();
    }

    private void initEntity(){
        preparedFacultyEntity = FacultyEntity.builder()
                .withId(1)
                .withNameUa("Faculty of computer science and cybernetics")
                .withMaxBudgetPlace(90)
                .withMaxPlace(130)
                .withRequirementEntityId(1)
                .build();

        testFacultyEntity = FacultyEntity.builder()
                .withId(10)
                .withNameUa("Faculty of computer science and cybernetics")
                .withMaxBudgetPlace(90)
                .withMaxPlace(120)
                .withRequirementEntityId(0)
                .build();
    }
}
