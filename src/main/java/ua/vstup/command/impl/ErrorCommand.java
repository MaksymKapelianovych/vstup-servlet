package ua.vstup.command.impl;

import ua.vstup.annotation.CommandMapping;
import ua.vstup.command.Command;
import ua.vstup.constantutils.Attribute;
import ua.vstup.constantutils.Url;

import javax.servlet.http.HttpServletRequest;

@CommandMapping(url = Url.ERROR)
public class ErrorCommand extends AbstractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Throwable throwable = (Throwable) request.getAttribute(Attribute.SERVLET_ERROR_EXCEPTION);

        if (throwable != null) {
            request.setAttribute(Attribute.ERROR_CAUSE, throwable.getMessage());
        } else {
            request.setAttribute(Attribute.ERROR_CAUSE, request.getAttribute(Attribute.SERVLET_ERROR_EXCEPTION));
        }
        return "/error.jsp";
    }
}
