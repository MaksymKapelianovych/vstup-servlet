package ua.vstup.controller;

import static ua.vstup.constantutils.Url.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {LOGIN_REDIRECT, REGISTER_REDIRECT, LOGOUT_REDIRECT})
public class RedirectController  extends AbstractController{
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + urlToCommand.get(request.getRequestURI()).execute(request));
    }
}
