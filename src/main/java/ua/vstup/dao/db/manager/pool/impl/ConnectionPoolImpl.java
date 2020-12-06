package ua.vstup.dao.db.manager.pool.impl;

import ua.vstup.dao.db.manager.DbConfig;
import ua.vstup.dao.db.manager.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class ConnectionPoolImpl implements ConnectionPool {
    private final static String POOL_ERROR = "Maximum pool size reached, no available connection";
    private final static String GET_AFTER_SHUTDOWN_ERROR = "Pool was closed!";
    private static int INITIAL_POOL_SIZE = 16;

    private DbConfig config;
    private int poolSize;
    private boolean closed;

    private List<Connection> connectionPool;
    private List<Connection> usedConnections = new ArrayList<>();

    public ConnectionPoolImpl(DbConfig config) throws SQLException {
        this.config = config;
        DriverManager.setLoginTimeout(config.getConnectionTimeout());
        poolSize = config.getMaximumPoolSize() == 0 ? INITIAL_POOL_SIZE : config.getMaximumPoolSize();
        connectionPool = new ArrayList<>();
        for(int i = 0; i < poolSize; ++i){
            connectionPool.add(createConnection(config));
        }
        setClosed(false);
    }

    private static Connection createConnection(DbConfig config) throws SQLException {
        return DriverManager.getConnection(config.getJdbcUrl(), config.getUsername(), config.getPassword());
    }

    @Override
    public Connection getConnection() throws SQLException {
        if(isClosed()){
            throw new SQLException(GET_AFTER_SHUTDOWN_ERROR);
        }

        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        if(connection.isClosed()){
            connection = createConnection(config);
        }
        usedConnections.add(connection);
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

    @Override
    public DbConfig getConfig() {
        return config;
    }

    @Override
    public void shutdown() throws SQLException {
        for(int i = usedConnections.size() ; i > 0; --i ){
            releaseConnection(usedConnections.get(i-1));
        }
        for (Connection c : connectionPool) {
            c.close();
        }

        connectionPool.clear();

        setClosed(true);
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}
