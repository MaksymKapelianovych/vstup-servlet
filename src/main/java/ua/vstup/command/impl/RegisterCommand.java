package ua.vstup.command.impl;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.constantutils.Constants;
import ua.vstup.domain.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@CommandMapping(url = Constants.Urls.REGISTER_REDIRECT)
public class RegisterCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        //TODO create facade, save in service
        Subject subject1 = new Subject(null, SubjectName.valueOf(request.getParameter(Constants.Parameters.SUBJECT_NAME1)),
                Integer.valueOf(request.getParameter(Constants.Parameters.SUBJECT_RATE1)));
        Subject subject2 = new Subject(null, SubjectName.valueOf(request.getParameter(Constants.Parameters.SUBJECT_NAME2)),
                Integer.valueOf(request.getParameter(Constants.Parameters.SUBJECT_RATE2)));
        Subject subject3 = new Subject(null, SubjectName.valueOf(request.getParameter(Constants.Parameters.SUBJECT_NAME3)),
                Integer.valueOf(request.getParameter(Constants.Parameters.SUBJECT_RATE3)));
        Subject subject4 = new Subject(null, SubjectName.valueOf(request.getParameter(Constants.Parameters.SUBJECT_NAME4)),
                Integer.valueOf(request.getParameter(Constants.Parameters.SUBJECT_RATE4)));
        Subject subject5 = new Subject(null, SubjectName.valueOf(request.getParameter(Constants.Parameters.SUBJECT_NAME5)),
                Integer.valueOf(request.getParameter(Constants.Parameters.SUBJECT_RATE5)));

        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(subject1);
        subjectList.add(subject2);
        subjectList.add(subject3);
        subjectList.add(subject4);
        subjectList.add(subject5);


        Entrant entrant = Entrant.builder()
                .withName(request.getParameter(Constants.Parameters.NAME))
                .withEmail(request.getParameter(Constants.Parameters.EMAIL))
                .withPassword(request.getParameter(Constants.Parameters.PASSWORD))
                .withSchoolId(Integer.valueOf(request.getParameter(Constants.Parameters.SCHOOL_ID)))
                .withRole(Role.USER)
                .withRequirementId(null)
                .withActive(true)
                .build();

        getEntrantService(request).register(entrant, subjectList);
        request.getSession(false).setAttribute("entrant", entrant);
        return Constants.Urls.LOGIN_FORWARD;
    }
}
