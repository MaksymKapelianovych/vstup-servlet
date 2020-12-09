package ua.vstup.command.impl;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.constantutils.url.Url;

import javax.servlet.http.HttpServletRequest;

@CommandMapping(url = Url.REGISTER_FORWARD)
public class RegisterPageCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/register.jsp";
    }
}
