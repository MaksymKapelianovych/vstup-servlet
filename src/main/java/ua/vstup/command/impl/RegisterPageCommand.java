package ua.vstup.command.impl;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.constantutils.Constants;
import ua.vstup.domain.SubjectName;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@CommandMapping(url = Constants.Urls.REGISTER_FORWARD)
public class RegisterPageCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        List<SubjectName> subjectNames = Arrays.asList(SubjectName.values());
        request.setAttribute(Constants.Attributes.SUBJECT_NAMES, subjectNames);
        request.setAttribute(Constants.Attributes.ALL_SCHOOL, getSchoolService(request).getAll());
        return "/register.jsp";
    }
}
