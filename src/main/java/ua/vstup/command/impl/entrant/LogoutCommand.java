package ua.vstup.command.impl.entrant;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.command.impl.AbstractCommand;
import ua.vstup.constantutils.Constants;

import javax.servlet.http.HttpServletRequest;

@CommandMapping(url = Constants.Urls.LOGOUT_REDIRECT)
public class LogoutCommand  extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().removeAttribute(Constants.Attributes.ENTRANT);
        return Constants.Urls.LOGIN_FORWARD;
    }
}
