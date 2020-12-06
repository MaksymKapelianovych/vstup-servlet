package ua.vstup.reflection.loader;

import org.apache.log4j.Logger;
import ua.vstup.annotation.Autowired;
import ua.vstup.annotation.CommandMapping;
import ua.vstup.annotation.Dao;
import ua.vstup.annotation.Service;
import ua.vstup.command.Command;
import ua.vstup.dao.TransactionHandler;
import ua.vstup.dao.db.holder.ConnectionHolder;
import ua.vstup.dao.db.holder.ThreadLocalConnectionHolder;
import ua.vstup.dao.db.manager.ConnectionManager;
import ua.vstup.dao.db.manager.DbManager;

import javax.servlet.ServletContext;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ContextLoader extends AbstractContextLoader{
    private static final Logger LOGGER = Logger.getLogger(ContextLoader.class);
    private ConnectionHolder connectionHolder;
    private ConnectionManager connectionManager;
    private ServletContext servletContext;
    private Map<String, Command> urlToCommand = new HashMap<>();
    private Map<String, Object> services = new HashMap<>();
    private Map<String, Object> beans = new HashMap<>();

    public ContextLoader(ThreadLocalConnectionHolder connectionHolder, DbManager dbManager, ServletContext servletContext) {
        this.connectionHolder = connectionHolder;
        this.connectionManager = dbManager;
        this.servletContext = servletContext;
    }

    @Override
    public void load(String... packagesNames) {
        try {
            loadBeans(packagesNames);
            autowireBeans();
            manageServices();
            manageCommands();
        }catch (Exception e){
            LOGGER.error("Cannot load beans. ", e);
        }
        LOGGER.info("All beans load successfully");
    }

    @Override
    public void destroy(ServletContext servletContext) {
        connectionManager.shutdown();
    }

    @Override
    protected void loadBean(Class<?> c) throws ReflectiveOperationException {
        if (c.isAnnotationPresent(Dao.class)) {
            loadDao(c);
            return;
        }
        if (c.isAnnotationPresent(Service.class)) {
            loadService(c);
            return;
        }
        if (c.isAnnotationPresent(CommandMapping.class)) {
            loadCommandMapping(c);
        }
    }

    private void loadDao(Class<?> c) throws ReflectiveOperationException {
        Constructor<?> constructor = c.getConstructor(ConnectionHolder.class);
        Object daoImpl = constructor.newInstance(connectionHolder);
        String name = getNameByImplType(daoImpl, "Dao");
        if(name != null){
            beans.put(name, daoImpl);
        }else{
            LOGGER.debug(String.format("Dao %s wasn't logged because it's not dao", daoImpl));
        }
    }


    private void loadService(Class<?> c) throws ReflectiveOperationException {
        Constructor<?> constructor = c.getConstructor();
        Object serviceImpl = constructor.newInstance();
        String name = getNameByImplType(serviceImpl, "Service");
        if(name != null){
            services.put(name, serviceImpl);
            beans.put(name, serviceImpl);
        }else{
            LOGGER.debug(String.format("Service %s wasn't logged because it's not service", serviceImpl));
        }
    }
    private void loadCommandMapping(Class<?> c) throws ReflectiveOperationException {
        Constructor<?> constructor = c.getConstructor();
        Object commandImpl = constructor.newInstance();
        for(Object obj: commandImpl.getClass().getInterfaces()){
            if(obj.toString().contains("Command")){
                String pattern = c.getDeclaredAnnotation(CommandMapping.class).url();
                if (urlToCommand.containsKey(pattern)) {
                    throw new IllegalStateException("There is command with such url pattern!");
                }
                urlToCommand.put(pattern, (Command) commandImpl);
            }
        }
    }

    private void autowireBeans() throws IllegalAccessException {
        for(Object bean : beans.values()){
            for(Field field : bean.getClass().getDeclaredFields()){
                field.setAccessible(true);
                if(field.isAnnotationPresent(Autowired.class)){
                    Object beanToAutowire = beans.get(field.getType().getName());
                    if(beanToAutowire != null){
                        field.set(bean, beanToAutowire);
                    }
                }
            }
        }
    }

    private void manageServices() {
        for (Map.Entry<String, Object> entry : services.entrySet()) {
            Object service = entry.getValue();
            Object proxy = Proxy.newProxyInstance(
                    this.getClass().getClassLoader(),
                    service.getClass().getInterfaces(),
                    new TransactionHandler(connectionHolder, service, connectionManager)
            );
            servletContext.setAttribute(entry.getKey(), proxy);
        }
    }

    private void manageCommands() {
        servletContext.setAttribute("urlToCommandMap", urlToCommand);
    }

    private String getNameByImplType(Object o, String name) {
        String interfaceName = null;
        for(Object obj: o.getClass().getInterfaces()){
            if(obj.toString().contains(name)){
                interfaceName = obj.toString().replace("interface ", "");
                break;
            }
        }
        return interfaceName;
    }

}
