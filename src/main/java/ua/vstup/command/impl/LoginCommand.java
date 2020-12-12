package ua.vstup.command.impl;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.constantutils.Attribute;
import ua.vstup.constantutils.Parameter;
import ua.vstup.constantutils.Url;
import ua.vstup.domain.Entrant;

import javax.servlet.http.HttpServletRequest;

@CommandMapping(url = Url.LOGIN_REDIRECT)
public class LoginCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Entrant entrant = getEntrantService(request).login(request.getParameter(Parameter.EMAIL), request.getParameter(Parameter.PASSWORD));
        request.getSession(false).setAttribute(Attribute.ENTRANT, entrant);
        return Url.HOME_FORWARD;
    }
}