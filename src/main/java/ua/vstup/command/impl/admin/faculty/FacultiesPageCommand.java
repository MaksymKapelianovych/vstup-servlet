package ua.vstup.command.impl.admin.faculty;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.command.impl.AbstractCommand;
import ua.vstup.constantutils.Constants;
import ua.vstup.domain.Faculty;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CommandMapping(url = Constants.Urls.ADMIN_FACULTY_FORWARD)
public class FacultiesPageCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        List<Faculty> faculties = getFacultyService(request).getAll();
        request.setAttribute(Constants.Attributes.FACULTY_LIST, faculties);
        return "/WEB-INF/admin/faculty/faculties.jsp";
    }
}
