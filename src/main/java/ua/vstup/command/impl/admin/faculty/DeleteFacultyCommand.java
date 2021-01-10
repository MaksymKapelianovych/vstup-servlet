package ua.vstup.command.impl.admin.faculty;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.command.impl.AbstractCommand;
import ua.vstup.constantutils.Constants;

import javax.servlet.http.HttpServletRequest;

@CommandMapping(url = Constants.Urls.DELETE_FACULTY_REDIRECT)
public class DeleteFacultyCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        getFacultyService(request).delete(Integer.valueOf(request.getParameter(Constants.Parameters.FACULTY_ID)));
        return Constants.Urls.ADMIN_FACULTY_FORWARD;
    }
}
