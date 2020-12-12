package ua.vstup.controller;

import static ua.vstup.constantutils.Url.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {LOGIN_FORWARD, REGISTER_FORWARD, ERROR, HOME_FORWARD})
public class ForwardController extends AbstractController {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher(urlToCommand.get(request.getRequestURI()).execute(request)).forward(request, response);
    }
}
