package ua.vstup.command.impl.entrant;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.command.impl.AbstractCommand;
import ua.vstup.constantutils.Constants;
import ua.vstup.domain.FacultyInfo;
import ua.vstup.domain.Subject;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CommandMapping(url = Constants.Urls.ADD_REQUEST_FORWARD)
public class AddRequestPageCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Integer id = Integer.valueOf(request.getParameter(Constants.Parameters.FACULTY_ID));
        FacultyInfo facultyInfo = getFacultyService(request).getFacultyInfo(id);
        List<Subject> subjectList = getRequestService(request).jointSubjects(facultyInfo.getRequirementInfo(), getEntrant(request).getRequirementInfo());

        request.setAttribute(Constants.Attributes.FACULTY_INFO, facultyInfo);
        request.setAttribute(Constants.Attributes.SUBJECT_LIST, subjectList);

        return "/WEB-INF/entrant/add-request.jsp";
    }
}
