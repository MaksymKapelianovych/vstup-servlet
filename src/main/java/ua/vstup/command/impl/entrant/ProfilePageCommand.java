package ua.vstup.command.impl.entrant;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.command.impl.AbstractCommand;
import ua.vstup.constantutils.Constants;
import ua.vstup.domain.EntrantInfo;

import javax.servlet.http.HttpServletRequest;

@CommandMapping(url = Constants.Urls.PROFILE_FORWARD)
public class ProfilePageCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        EntrantInfo entrantInfo = getEntrantService(request).getEntrantInfo(getEntrant(request));
        return "/entrant/profile.jsp";
    }
}