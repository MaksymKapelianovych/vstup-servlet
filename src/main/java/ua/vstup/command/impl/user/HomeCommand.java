package ua.vstup.command.impl.user;


import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.command.impl.AbstractCommand;
import ua.vstup.constantutils.Attribute;
import ua.vstup.constantutils.Url;
import ua.vstup.domain.Entrant;
import ua.vstup.domain.Request;
import ua.vstup.domain.RequestInfoForEntrant;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CommandMapping(url = Url.HOME_FORWARD)
public class HomeCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Entrant entrant = getEntrant(request);
        List<RequestInfoForEntrant> requests = getRequestService(request).getAllInfoByEntrant(entrant);
        request.setAttribute(Attribute.REQUEST_LIST, requests);
        return "/home/home.jsp";
    }
}
