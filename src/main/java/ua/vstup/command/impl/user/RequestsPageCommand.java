package ua.vstup.command.impl.user;


import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.command.impl.AbstractCommand;
import ua.vstup.constantutils.Constants;
import ua.vstup.domain.Entrant;
import ua.vstup.domain.RequestInfoForEntrant;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CommandMapping(url = Constants.Urls.REQUESTS_FORWARD)
public class RequestsPageCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Entrant entrant = getEntrant(request);
        List<RequestInfoForEntrant> requests = getRequestService(request).getAllInfoByEntrant(entrant);
        request.setAttribute(Constants.Attributes.REQUEST_LIST, requests);
        return "/home/requests.jsp";
    }
}
