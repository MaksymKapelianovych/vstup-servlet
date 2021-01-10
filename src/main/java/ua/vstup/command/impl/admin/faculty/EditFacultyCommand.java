package ua.vstup.command.impl.admin.faculty;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.command.impl.AbstractCommand;
import ua.vstup.constantutils.Constants;
import ua.vstup.domain.Faculty;
import ua.vstup.domain.Subject;
import ua.vstup.domain.SubjectName;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@CommandMapping(url = Constants.Urls.EDIT_FACULTY_REDIRECT)
public class EditFacultyCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/admin/faculty/faculties.jsp";
    }
}
