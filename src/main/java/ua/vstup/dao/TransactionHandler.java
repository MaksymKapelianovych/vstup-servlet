package ua.vstup.dao;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.vstup.annotation.Transactional;
import ua.vstup.dao.db.holder.ConnectionHolder;
import ua.vstup.dao.db.manager.ConnectionManager;
import ua.vstup.exception.DatabaseInteractionException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;

public class TransactionHandler implements InvocationHandler {

    //private static final Logger LOGGER = LogManager.getLogger(TransactionHandler.class);
    private static final String COMMIT_FAILED = "Commit failed";
    private static final String INVOCATION_FAILED = "Invocation failed";
    private static final String ROLLBACK_FAILED = "Rollback failed";
    private static final String CLOSING_CONNECTION_FAILED = "Closing connection failed";
    private final ConnectionManager connectionManager;
    private final ConnectionHolder connectionHolder;
    private final Object serviceToInvoke;

    /**
     * Creates a new transaction handler.
     *
     * @param holder          connection holder
     * @param serviceToInvoke service to invoke
     * @param manager         connection manager
     */
    public TransactionHandler(ConnectionHolder holder, Object serviceToInvoke, ConnectionManager manager) {
        this.connectionManager = manager;
        this.serviceToInvoke = serviceToInvoke;
        this.connectionHolder = holder;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) {
        return method.isAnnotationPresent(Transactional.class) ?
                invokeWithTransaction(method, objects) : invokeWithoutTransaction(method, objects);

    }

    private Object invokeWithoutTransaction(Method method, Object[] args) {
        //LOGGER.debug("Invoking without transaction");
        Connection connection = connectionManager.getConnection();
        connectionHolder.set(connection);
        try {
            connection.setAutoCommit(true);
            return method.invoke(serviceToInvoke, args);
        } catch (Exception e) {
            throw new DatabaseInteractionException(INVOCATION_FAILED, e);
        } finally {
            closeConnection(connection);
            connectionHolder.remove();
        }
    }

    private Object invokeWithTransaction(Method method, Object[] args) {
        //LOGGER.debug("Invoking with transaction");
        Connection connection = connectionManager.getConnection();
        connectionHolder.set(connection);
        try {
            Object result;
            connection.setAutoCommit(false);
            result = method.invoke(serviceToInvoke, args);
            connection.commit();
            return result;
        } catch (SQLException e) {
            rollback(connection);
            throw new DatabaseInteractionException(COMMIT_FAILED, e);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new DatabaseInteractionException(INVOCATION_FAILED, e);
        } finally {
            closeConnection(connection);
            connectionHolder.remove();
        }
    }

    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DatabaseInteractionException(CLOSING_CONNECTION_FAILED, e);
        }
    }

    private void rollback(Connection connection) {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new DatabaseInteractionException(ROLLBACK_FAILED, e);
        }
    }
}
