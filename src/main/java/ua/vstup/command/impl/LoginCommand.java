package ua.vstup.command.impl;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.constantutils.url.Url;
import ua.vstup.domain.Entrant;

import javax.servlet.http.HttpServletRequest;

@CommandMapping(url = Url.LOGIN_REDIRECT)
public class LoginCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Entrant entrant = getEntrantService(request).login(request.getParameter("email"), request.getParameter("password"));
        request.getSession(false).setAttribute("entrant", entrant);
        return Url.HOME_FORWARD;
    }
}