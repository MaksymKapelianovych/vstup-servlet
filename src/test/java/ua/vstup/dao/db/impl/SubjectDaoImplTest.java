package ua.vstup.dao.db.impl;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ua.vstup.dao.SubjectDao;
import ua.vstup.dao.db.holder.ConnectionHolder;
import ua.vstup.dao.db.holder.ThreadLocalConnectionHolder;
import ua.vstup.dao.db.manager.DbManager;
import ua.vstup.dao.impl.SubjectDaoImpl;
import ua.vstup.entity.SubjectEntity;
import ua.vstup.entity.SubjectNameEntity;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class SubjectDaoImplTest {
    private static String SCHEMA_PATH = "src/test/resources/database/schema.sql";
    private static String DATA_PATH = "src/test/resources/database/data.sql";
    private static String DB_PATH = "properties/test_db";

    private static String ERROR_MESSAGE = "delete.by.id.for.subject.unsupported";

    private SubjectEntity preparedSubjectEntity;
    private SubjectEntity testSubjectEntity;
    private static DbManager manager;
    private static ConnectionHolder connectionHolder;
    private SubjectDao subjectDao;

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
            subjectDao = new SubjectDaoImpl(connectionHolder);

            initEntity();
        }catch (Exception e){
            fail();
        }
    }

    @Test
    public void findByIdShouldReturnSubject(){
        Optional<SubjectEntity> subjectEntity = subjectDao.findById(preparedSubjectEntity.getId());
        assertTrue(subjectEntity.isPresent());
    }

    @Test
    public void findByIdShouldReturnNull(){
        Optional<SubjectEntity> subjectEntity = subjectDao.findById(testSubjectEntity.getId());
        assertFalse(subjectEntity.isPresent());
    }

    @Test
    public void updateShouldReturnTrue(){
        assertTrue(subjectDao.update(preparedSubjectEntity));
    }

    @Test
    public void updateShouldReturnFalse(){
        assertFalse(subjectDao.update(testSubjectEntity));
    }

    @Test
    public void deleteShouldThrowUnsupportedOperationException(){
        exception.expect(UnsupportedOperationException.class);
        exception.expectMessage(ERROR_MESSAGE);
        subjectDao.deleteById(preparedSubjectEntity.getId());
    }


    private void initEntity(){
        preparedSubjectEntity = new SubjectEntity(1, SubjectNameEntity.ENGLISH, 120);

        testSubjectEntity = new SubjectEntity(0, SubjectNameEntity.ENGLISH, 150);
    }
}
