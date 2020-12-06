package ua.vstup.reflection;

import ua.vstup.dao.db.holder.ThreadLocalConnectionHolder;
import ua.vstup.dao.db.manager.DbManager;
import ua.vstup.reflection.loader.ContextLoader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoadListener implements ServletContextListener {
    private ContextLoader loader;
    private static final String DB_FILENAME = "properties/db";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        loader = new ContextLoader(new ThreadLocalConnectionHolder(), new DbManager(DB_FILENAME), sce.getServletContext());
        loader.load("ua.vstup.dao", "ua.vstup.command", "ua.vstup.service");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        loader.destroy(sce.getServletContext());
    }
}
