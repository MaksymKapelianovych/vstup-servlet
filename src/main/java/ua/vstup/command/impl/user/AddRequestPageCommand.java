package ua.vstup.command.impl.user;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.command.impl.AbstractCommand;
import ua.vstup.constantutils.Constants;

import javax.servlet.http.HttpServletRequest;

@CommandMapping(url = Constants.Urls.ADD_REQUEST_REDIRECT)
public class AddRequestPageCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String id = request.getParameter(Constants.Parameters.FACULTY_ID);
        if(id != null){
            Integer faculty_id = Integer.valueOf(id);
            request.setAttribute(Constants.Attributes.FACULTY_ID, faculty_id);
        }

        return "/home/add-request.jsp";
    }
}
