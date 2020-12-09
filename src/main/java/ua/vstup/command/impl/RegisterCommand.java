package ua.vstup.command.impl;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.constantutils.url.Url;
import ua.vstup.domain.*;

import javax.servlet.http.HttpServletRequest;

@CommandMapping(url = Url.REGISTER_REDIRECT)
public class RegisterCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Subject subject1 = new Subject(null, SubjectName.valueOf(request.getParameter("subject_name1")),
                Integer.valueOf(request.getParameter("subject_rate1")));
        Subject subject2 = new Subject(null, SubjectName.valueOf(request.getParameter("subject_name2")),
                Integer.valueOf(request.getParameter("subject_rate2")));
        Subject subject3 = new Subject(null, SubjectName.valueOf(request.getParameter("subject_name3")),
                Integer.valueOf(request.getParameter("subject_rate3")));
        Subject subject4 = new Subject(null, SubjectName.valueOf(request.getParameter("subject_name4")),
                Integer.valueOf(request.getParameter("subject_rate4")));
        Subject subject5 = new Subject(null, SubjectName.valueOf(request.getParameter("subject_name5")),
                Integer.valueOf(request.getParameter("subject_rate5")));

        Requirement requirement = Requirement.builder()
                .withFirstSubjectId(getSubjectService(request).add(subject1))
                .withSecondSubjectId(getSubjectService(request).add(subject2))
                .withThirdSubjectId(getSubjectService(request).add(subject3))
                .withFourthSubjectId(getSubjectService(request).add(subject4))
                .withFifthSubjectId(getSubjectService(request).add(subject5))
                .build();

        Entrant entrant = Entrant.builder()
                .withName(request.getParameter("name"))
                .withEmail(request.getParameter("email"))
                .withPassword(request.getParameter("password"))
                .withSchoolId(Integer.valueOf(request.getParameter("school_id")))
                .withRole(Role.USER)
                .withRequirementId(getRequirementService(request).add(requirement))
                .withActive(true)
                .build();

        getEntrantService(request).register(entrant);
        request.getSession(false).setAttribute("entrant", entrant);
        return Url.HOME_FORWARD;
    }
}
