package ua.vstup.command.impl;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.constantutils.Constants;
import ua.vstup.domain.Entrant;

import javax.servlet.http.HttpServletRequest;

@CommandMapping(url = Constants.Urls.LOGIN_REDIRECT)
public class LoginCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Entrant entrant = getEntrantService(request).login(
                request.getParameter(Constants.Parameters.EMAIL),
                request.getParameter(Constants.Parameters.PASSWORD));
        request.getSession(false).setAttribute(Constants.Attributes.ENTRANT, entrant);
        return Constants.Urls.REQUESTS_FORWARD;
    }
}