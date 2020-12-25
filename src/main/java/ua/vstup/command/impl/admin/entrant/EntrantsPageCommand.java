package ua.vstup.command.impl.admin.entrant;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.command.impl.AbstractCommand;
import ua.vstup.constantutils.Constants;
import ua.vstup.domain.Entrant;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CommandMapping(url = Constants.Urls.ADMIN_ENTRANT_FORWARD)
public class EntrantsPageCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        List<Entrant> entrantList = getEntrantService(request).getAllEntrants();
        request.setAttribute(Constants.Attributes.ENTRANT_LIST, entrantList);
        return "/admin/entrant/entrants.jsp";
    }
}
