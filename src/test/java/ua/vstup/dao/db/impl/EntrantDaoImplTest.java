package ua.vstup.dao.db.impl;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ua.vstup.dao.EntrantDao;
import ua.vstup.dao.db.holder.ConnectionHolder;
import ua.vstup.dao.db.holder.ThreadLocalConnectionHolder;
import ua.vstup.dao.db.manager.DbManager;
import ua.vstup.dao.impl.EntrantDaoImpl;
import ua.vstup.entity.EntrantEntity;
import ua.vstup.entity.RoleEntity;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Optional;

import static org.junit.Assert.*;

public class EntrantDaoImplTest {
    private static String SCHEMA_PATH = "src/test/resources/database/schema.sql";
    private static String DATA_PATH = "src/test/resources/database/data.sql";
    private static String DB_PATH = "properties/test_db";

    private static String ERROR_MESSAGE = "delete.by.id.for.entrant.unsupported";

    private EntrantEntity preparedEntrantEntity;
    private EntrantEntity testEntrantEntity;
    private static DbManager manager;
    private static ConnectionHolder connectionHolder;
    private EntrantDao entrantDao;

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
            entrantDao = new EntrantDaoImpl(connectionHolder);

            initEntity();
        }catch (Exception e){
            fail();
        }
    }

    @Test
    public void findByIdShouldReturnEntrant(){
        Optional<EntrantEntity> entrantEntity = entrantDao.findById(preparedEntrantEntity.getId());
        assertTrue(entrantEntity.isPresent());
    }

    @Test
    public void findByIdShouldReturnNull(){
        Optional<EntrantEntity> entrantEntity = entrantDao.findById(testEntrantEntity.getId());
        assertFalse(entrantEntity.isPresent());
    }

    @Test
    public void updateShouldReturnTrue(){
        assertTrue(entrantDao.update(preparedEntrantEntity));
    }

    @Test
    public void updateShouldReturnFalse(){
        assertFalse(entrantDao.update(testEntrantEntity));
    }

    @Test
    public void deleteShouldThrowUnsupportedOperationException(){
        exception.expect(UnsupportedOperationException.class);
        exception.expectMessage(ERROR_MESSAGE);
        entrantDao.deleteById(preparedEntrantEntity.getId());
    }


    private void initEntity(){
        preparedEntrantEntity = EntrantEntity.builder()
                .withId(1)
                .withName("Maksym Kapelianovych Volodymyrovych")
                .withPassword("admin")
                .withEmail("vfrc.zomby30@gmail.com")
                .withSchoolEntityId(1)
                .withRoleEntity(RoleEntity.ADMIN)
                .withRequirementEntityId(3)
                .withActive(true)
                .build();

        testEntrantEntity = EntrantEntity.builder()
                .withId(0)
                .withName("Maksym Kapelianovych Volodymyrovych")
                .withPassword("admin")
                .withEmail("vfrc.zomby30@gmail.com")
                .withSchoolEntityId(1)
                .withRoleEntity(RoleEntity.ADMIN)
                .withRequirementEntityId(3)
                .withActive(true)
                .build();
    }
}
