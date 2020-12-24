package ua.vstup.command.impl.admin;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.command.impl.AbstractCommand;
import ua.vstup.constantutils.Constants;
import ua.vstup.domain.Entrant;

import javax.servlet.http.HttpServletRequest;

@CommandMapping(url = Constants.Urls.ADMIN_PROFILE_FORWARD)
public class ProfilePageCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Entrant entrant = getEntrant(request);
        request.setAttribute(Constants.Attributes.ENTRANT, entrant);
        return "/admin/profile.jsp";
    }
}
