package ua.vstup.command.impl.admin;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.command.impl.AbstractCommand;
import ua.vstup.constantutils.Constants;
import ua.vstup.domain.Faculty;
import ua.vstup.domain.FacultyInfo;

import javax.servlet.http.HttpServletRequest;

@CommandMapping(url = Constants.Urls.EDIT_FACULTY_FORWARD)
public class EditFacultyPageCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        //TODO change to FacultyInfo
        FacultyInfo faculty = getFacultyService(request).getFacultyInto(Integer.valueOf(request.getParameter(Constants.Parameters.FACULTY_ID)));
        request.setAttribute(Constants.Attributes.FACULTY_INFO, faculty);
        return "/admin/faculty/edit-faculty.jsp";
    }
}
