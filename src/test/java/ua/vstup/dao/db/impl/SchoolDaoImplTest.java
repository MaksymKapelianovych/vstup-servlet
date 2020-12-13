package ua.vstup.dao.db.impl;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ua.vstup.dao.SchoolDao;
import ua.vstup.dao.db.holder.ConnectionHolder;
import ua.vstup.dao.db.holder.ThreadLocalConnectionHolder;
import ua.vstup.dao.db.manager.DbManager;
import ua.vstup.dao.impl.SchoolDaoImpl;
import ua.vstup.entity.RegionEntity;
import ua.vstup.entity.SchoolEntity;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Optional;

import static org.junit.Assert.*;

public class SchoolDaoImplTest {
    private static String SCHEMA_PATH = "src/test/resources/database/schema.sql";
    private static String DATA_PATH = "src/test/resources/database/data.sql";
    private static String DB_PATH = "properties/test_db";

    private static String ERROR_MESSAGE = "delete.by.id.for.school.unsupported";

    private SchoolEntity preparedSchoolEntity;
    private SchoolEntity testSchoolEntity;
    private static DbManager manager;
    private static ConnectionHolder connectionHolder;
    private SchoolDao schoolDao;

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
            schoolDao = new SchoolDaoImpl(connectionHolder);

            initEntity();
        }catch (Exception e){
            fail();
        }
    }

    @Test
    public void findByIdShouldReturnSchool(){
        Optional<SchoolEntity> schoolEntity = schoolDao.findById(preparedSchoolEntity.getId());
        assertTrue(schoolEntity.isPresent());
    }

    @Test
    public void findByIdShouldReturnNull(){
        Optional<SchoolEntity> schoolEntity = schoolDao.findById(testSchoolEntity.getId());
        assertFalse(schoolEntity.isPresent());
    }

    @Test
    public void updateShouldReturnTrue(){
        assertTrue(schoolDao.update(preparedSchoolEntity));
    }

    @Test
    public void updateShouldReturnFalse(){
        assertFalse(schoolDao.update(testSchoolEntity));
    }

    @Test
    public void deleteShouldThrowUnsupportedOperationException(){
        exception.expect(UnsupportedOperationException.class);
        exception.expectMessage(ERROR_MESSAGE);
        schoolDao.deleteById(preparedSchoolEntity.getId());
    }


    private void initEntity(){
        preparedSchoolEntity = SchoolEntity.builder()
                .withId(1)
                .withNameUa("School №1")
                .withCityUa("Kyiv")
                .withRegionEntity(RegionEntity.KYIV)
                .withActive(true)
                .build();

        testSchoolEntity = SchoolEntity.builder()
                .withId(0)
                .withNameUa("School №1")
                .withCityUa("Kyiv")
                .withRegionEntity(RegionEntity.KYIV)
                .withActive(true)
                .build();
    }
}
