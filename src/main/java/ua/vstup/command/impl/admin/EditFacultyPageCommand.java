package ua.vstup.command.impl.admin;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.command.impl.AbstractCommand;
import ua.vstup.constantutils.Constants;
import ua.vstup.domain.Faculty;

import javax.servlet.http.HttpServletRequest;

@CommandMapping(url = Constants.Urls.EDIT_FACULTY_FORWARD)
public class EditFacultyPageCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        //TODO change to FacultyInfo
        Faculty faculty = getFacultyService(request).findById(Integer.valueOf(request.getParameter(Constants.Parameters.FACULTY_ID)));
        request.setAttribute(Constants.Attributes.FACULTY, faculty);
        return "/admin/faculty/edit-faculty.jsp";
    }
}
