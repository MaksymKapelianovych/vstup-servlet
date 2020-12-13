package ua.vstup.command.impl.user;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.command.impl.AbstractCommand;
import ua.vstup.constantutils.Attribute;
import ua.vstup.constantutils.Url;

import javax.servlet.http.HttpServletRequest;

@CommandMapping(url = Url.LOGOUT_REDIRECT)
public class LogoutCommand  extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().removeAttribute(Attribute.ENTRANT);
        return Url.LOGIN_FORWARD;
    }
}
