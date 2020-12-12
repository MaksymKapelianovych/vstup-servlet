package ua.vstup.command.impl.user;


import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.command.impl.AbstractCommand;
import ua.vstup.constantutils.Url;

import javax.servlet.http.HttpServletRequest;

@CommandMapping(url = Url.HOME_FORWARD)
public class HomeCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/home/home.jsp";
    }
}
