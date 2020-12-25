package ua.vstup.controller;

import ua.vstup.constantutils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {Constants.Urls.LOGIN_FORWARD, Constants.Urls.REGISTER_FORWARD,
        Constants.Urls.ERROR, Constants.Urls.REQUESTS_FORWARD, Constants.Urls.ENTRANT_FACULTY_FORWARD,
        Constants.Urls.ADMIN_FACULTY_FORWARD, Constants.Urls.ENTRANT_PROFILE_FORWARD, Constants.Urls.ADD_FACULTY_FORWARD,
        Constants.Urls.EDIT_FACULTY_FORWARD, Constants.Urls.ADMIN_ENTRANT_FORWARD,
        Constants.Urls.ADMIN_PROFILE_FORWARD, Constants.Urls.ADMIN_REQUEST_FORWARD
})
public class ForwardController extends AbstractController {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher(urlToCommand.get(request.getRequestURI()).execute(request)).forward(request, response);
    }

}
