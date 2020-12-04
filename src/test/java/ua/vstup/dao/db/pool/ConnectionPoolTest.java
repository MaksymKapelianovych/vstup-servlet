package ua.vstup.dao.db.pool;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ua.vstup.dao.db.manager.DbConfig;
import ua.vstup.dao.db.manager.pool.ConnectionPool;
import ua.vstup.dao.db.manager.pool.impl.ConnectionPoolImpl;

import java.sql.SQLException;
import java.util.ResourceBundle;

import static org.junit.Assert.assertTrue;

public class ConnectionPoolTest {
    private static final String DB_URL = "db.url";
    private static final String DB_USERNAME = "db.username";
    private static final String DB_PASS = "db.password";
    private static final String DB_DRIVER = "db.driver";
    private static final String DB_POOL_SIZE = "db.pool.size";
    private static final String DB_TIMEOUT = "db.timeout";
    private static final String DATABASE_PROPERTIES_FILENAME = "properties.db";
    private final DbConfig config = new DbConfig();

    private int getIntProperty(ResourceBundle resource, String dbPoolSize) {
        return Integer.parseInt(resource.getString(dbPoolSize));
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void init(){
        ResourceBundle resource = ResourceBundle.getBundle(DATABASE_PROPERTIES_FILENAME);
        config.setDriverClassName(resource.getString(DB_DRIVER));
        config.setJdbcUrl(resource.getString(DB_URL));
        config.setUsername(resource.getString(DB_USERNAME));
        config.setPassword(resource.getString(DB_PASS));
        config.setMaximumPoolSize(getIntProperty(resource, DB_POOL_SIZE));
        config.setConnectionTimeout(getIntProperty(resource, DB_TIMEOUT));
    }

    @Test
    public void whenCalledGetConnection_thenCorrect() throws SQLException {
        ConnectionPool connectionPool = new ConnectionPoolImpl(config);
        assertTrue(connectionPool.getConnection().isValid(config.getConnectionTimeout()));
    }
}
