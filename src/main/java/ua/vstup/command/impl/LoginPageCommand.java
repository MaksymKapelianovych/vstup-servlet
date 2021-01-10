package ua.vstup.command.impl;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.constantutils.Constants;

import javax.servlet.http.HttpServletRequest;

@CommandMapping(url = Constants.Urls.LOGIN_FORWARD)
public class LoginPageCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/login.jsp";
    }
}
