package ua.vstup.controller;

import ua.vstup.command.Command;

import javax.servlet.http.HttpServlet;
import java.util.Map;

public abstract class AbstractController extends HttpServlet {
    protected Map<String, Command> urlToCommand;

    @Override
    public void init() {
        this.urlToCommand = (Map<String, Command>) getServletContext().getAttribute("urlToCommandMap");
    }
}
