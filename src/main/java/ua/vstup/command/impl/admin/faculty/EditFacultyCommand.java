package ua.vstup.command.impl.admin.faculty;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.command.impl.AbstractCommand;
import ua.vstup.constantutils.Constants;

import javax.servlet.http.HttpServletRequest;

@CommandMapping(url = Constants.Urls.EDIT_FACULTY_REDIRECT)
public class EditFacultyCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/admin/faculty/faculties.jsp";
    }
}
