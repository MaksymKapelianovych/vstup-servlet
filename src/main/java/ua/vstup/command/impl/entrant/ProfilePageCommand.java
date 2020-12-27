package ua.vstup.command.impl.entrant;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.command.impl.AbstractCommand;
import ua.vstup.constantutils.Constants;
import ua.vstup.domain.EntrantInfo;

import javax.servlet.http.HttpServletRequest;

@CommandMapping(url = Constants.Urls.ENTRANT_PROFILE_FORWARD)
public class ProfilePageCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        EntrantInfo entrantInfo = getEntrant(request);
        request.getSession(false).setAttribute(Constants.Attributes.ENTRANT_INFO, entrantInfo);
        return "/entrant/profile.jsp";
    }
}
