package ua.vstup.command.impl.admin.entrant;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.command.impl.AbstractCommand;
import ua.vstup.constantutils.Constants;

import javax.servlet.http.HttpServletRequest;

@CommandMapping(url = Constants.Urls.ADMIN_ENTRANT_ENABLE_REDIRECT)
public class EnableEntrantCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        getEntrantService(request).enable(Integer.valueOf(request.getParameter(Constants.Parameters.ENTRANT_ID)));
        return Constants.Urls.ADMIN_ENTRANT_FORWARD;
    }
}
