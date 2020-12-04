package ua.vstup.dao.db.manager.pool;

import ua.vstup.dao.db.manager.DbConfig;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionPool {
    Connection getConnection() throws SQLException;
    boolean releaseConnection(Connection connection);
    DbConfig getConfig();

    void shutdown() throws SQLException;
}
