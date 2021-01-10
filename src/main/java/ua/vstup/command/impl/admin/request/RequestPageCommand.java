package ua.vstup.command.impl.admin.request;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.command.impl.AbstractCommand;
import ua.vstup.constantutils.Constants;
import ua.vstup.domain.Request;
import ua.vstup.domain.RequestInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CommandMapping(url = Constants.Urls.ADMIN_REQUEST_FORWARD)
public class RequestPageCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        List<RequestInfo> requests = getRequestService(request).getAll();
        request.setAttribute(Constants.Attributes.REQUEST_LIST, requests);
        return "/WEB-INF/admin/request/requests.jsp";
    }
}
