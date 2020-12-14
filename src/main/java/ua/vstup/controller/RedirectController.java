package ua.vstup.controller;

import ua.vstup.constantutils.Constants;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {Constants.Urls.LOGIN_REDIRECT, Constants.Urls.REGISTER_REDIRECT,
        Constants.Urls.LOGOUT_REDIRECT, Constants.Urls.ADD_REQUEST_REDIRECT})
public class RedirectController  extends AbstractController{
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + urlToCommand.get(request.getRequestURI()).execute(request));
    }
}
