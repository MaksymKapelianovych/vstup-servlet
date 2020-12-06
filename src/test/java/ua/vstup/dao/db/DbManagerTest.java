package ua.vstup.dao.db;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ua.vstup.dao.db.manager.DbConfig;
import ua.vstup.dao.db.manager.DbManager;
import ua.vstup.dao.db.manager.pool.ConnectionPool;
import ua.vstup.dao.db.manager.pool.impl.ConnectionPoolImpl;

import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class DbManagerTest {
    private static final String DATABASE_PROPERTIES_FILENAME = "properties/db";
    private static final String EXPECTED_MESSAGE = "Connection wasn't set ";

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testConfiguration() throws SQLException {
        DbManager manager = new DbManager(DATABASE_PROPERTIES_FILENAME);
        assertNotNull(manager);
        assertNotNull(manager.getConnection());
        manager.shutdown();
    }

    @Test
    public void testConnectionShouldThrowIllegalStateException() throws SQLException {
        exception.expect(IllegalStateException.class);
        exception.expectMessage(EXPECTED_MESSAGE);
        DbManager manager = new DbManager(DATABASE_PROPERTIES_FILENAME);
        manager.shutdown();
        manager.getConnection();
    }
}
