package ua.vstup.command.impl.entrant;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.command.impl.AbstractCommand;
import ua.vstup.constantutils.Constants;
import ua.vstup.domain.Faculty;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CommandMapping(url = Constants.Urls.ENTRANT_FACULTY_FORWARD)
public class FacultiesPageCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        List<Faculty> faculties = getFacultyService(request).getAllActive();
        request.setAttribute(Constants.Attributes.FACULTY_LIST, faculties);
        return "/WEB-INF/entrant/faculties.jsp";
    }
}
