package ua.vstup.command.impl.admin;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.command.impl.AbstractCommand;
import ua.vstup.constantutils.Constants;
import ua.vstup.domain.SubjectName;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@CommandMapping(url = Constants.Urls.ADD_FACULTY_FORWARD)
public class AddFacultyPageCommand extends AbstractCommand implements Command  {
    @Override
    public String execute(HttpServletRequest request) {

        List<SubjectName> subjectNames = Arrays.asList(SubjectName.values());
        request.setAttribute(Constants.Attributes.SUBJECT_NAMES, subjectNames);
        return "/admin/faculty/add-faculty.jsp";
    }
}
