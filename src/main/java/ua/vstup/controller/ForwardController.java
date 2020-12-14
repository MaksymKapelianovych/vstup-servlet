package ua.vstup.controller;

import ua.vstup.constantutils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {Constants.Urls.LOGIN_FORWARD, Constants.Urls.REGISTER_FORWARD,
        Constants.Urls.ERROR, Constants.Urls.REQUESTS_FORWARD, Constants.Urls.FACULTIES_FORWARD,
        Constants.Urls.PROFILE_FORWARD})
public class ForwardController extends AbstractController {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher(urlToCommand.get(request.getRequestURI()).execute(request)).forward(request, response);
    }
}
