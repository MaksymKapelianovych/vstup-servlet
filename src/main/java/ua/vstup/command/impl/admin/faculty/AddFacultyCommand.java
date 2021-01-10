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

@CommandMapping(url = Constants.Urls.ADD_FACULTY_REDIRECT)
public class AddFacultyCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Subject subject1 = new Subject(null, SubjectName.valueOf(request.getParameter(Constants.Parameters.SUBJECT_NAME1)),
                Integer.valueOf(request.getParameter(Constants.Parameters.SUBJECT_RATE1)));
        Subject subject2 = new Subject(null, SubjectName.valueOf(request.getParameter(Constants.Parameters.SUBJECT_NAME2)),
                Integer.valueOf(request.getParameter(Constants.Parameters.SUBJECT_RATE2)));
        Subject subject3 = new Subject(null, SubjectName.valueOf(request.getParameter(Constants.Parameters.SUBJECT_NAME3)),
                Integer.valueOf(request.getParameter(Constants.Parameters.SUBJECT_RATE3)));


        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(subject1);
        subjectList.add(subject2);
        subjectList.add(subject3);

        Faculty faculty = Faculty.builder()
                .withNameEn(request.getParameter(Constants.Parameters.NAME_EN))
                .withNameUa(request.getParameter(Constants.Parameters.NAME_UA))
                .withMaxBudgetPlace(Integer.valueOf(request.getParameter(Constants.Parameters.MAX_BUDGET_PLACES)))
                .withMaxPlace(Integer.valueOf(request.getParameter(Constants.Parameters.MAX_PLACES)))
                .withActive(true)
                .build();

        getFacultyService(request).add(faculty, subjectList);
        return Constants.Urls.ADMIN_FACULTY_FORWARD;
    }
}
