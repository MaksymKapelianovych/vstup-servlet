package ua.vstup.command.impl;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.constantutils.Constants;

import javax.servlet.http.HttpServletRequest;

@CommandMapping(url = Constants.Urls.ERROR)
public class ErrorCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Throwable throwable = (Throwable) request.getAttribute(Constants.Attributes.SERVLET_ERROR_EXCEPTION);

        if (throwable != null) {
            request.setAttribute(Constants.Attributes.ERROR_CAUSE, throwable.getMessage());
        } else {
            request.setAttribute(Constants.Attributes.ERROR_CAUSE, request.getAttribute(Constants.Attributes.SERVLET_ERROR_EXCEPTION));
        }
        return "/error.jsp";
    }
}
