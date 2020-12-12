package ua.vstup.command.impl;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.constantutils.Attribute;
import ua.vstup.constantutils.Url;
import ua.vstup.domain.SubjectName;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@CommandMapping(url = Url.REGISTER_FORWARD)
public class RegisterPageCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        List<SubjectName> subjectNames = Arrays.asList(SubjectName.values());
        request.setAttribute(Attribute.SUBJECT_NAMES, subjectNames);
        return "/register.jsp";
    }
}
