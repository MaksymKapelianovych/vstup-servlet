package ua.vstup.command.impl.admin;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.command.impl.AbstractCommand;
import ua.vstup.constantutils.Constants;
import ua.vstup.domain.Entrant;
import ua.vstup.domain.EntrantInfo;

import javax.servlet.http.HttpServletRequest;

@CommandMapping(url = Constants.Urls.ADMIN_PROFILE_FORWARD)
public class ProfilePageCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        EntrantInfo entrant = getEntrant(request);
        request.setAttribute(Constants.Attributes.ENTRANT_INFO, entrant);
        return "/admin/profile.jsp";
    }
}
