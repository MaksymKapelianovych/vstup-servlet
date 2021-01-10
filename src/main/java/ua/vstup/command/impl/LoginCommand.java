package ua.vstup.command.impl;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.constantutils.Constants;
import ua.vstup.domain.Entrant;
import ua.vstup.domain.EntrantInfo;
import ua.vstup.domain.Role;

import javax.servlet.http.HttpServletRequest;

@CommandMapping(url = Constants.Urls.LOGIN_REDIRECT)
public class LoginCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        EntrantInfo entrant = getEntrantService(request).login(
                request.getParameter(Constants.Parameters.EMAIL),
                request.getParameter(Constants.Parameters.PASSWORD));
        if(entrant == null){
            return Constants.Urls.LOGIN_FORWARD;
        }

        request.getSession(false).setAttribute(Constants.Attributes.ENTRANT_INFO, entrant);


        if(entrant.getRole() == Role.USER){
            return Constants.Urls.ENTRANT_PROFILE_FORWARD;
        }else{
            return Constants.Urls.ADMIN_PROFILE_FORWARD;
        }

    }
}