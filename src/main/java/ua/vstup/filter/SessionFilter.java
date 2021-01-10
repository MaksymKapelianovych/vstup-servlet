package ua.vstup.filter;

import ua.vstup.constantutils.Constants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class SessionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if (req.getSession(false) == null) {
            HttpSession session = req.getSession(true);
            session.setAttribute(Constants.Attributes.PAGE, 1);
            session.setAttribute(Constants.Attributes.LOCALE, Constants.Attributes.EN);
        }
        filterChain.doFilter(req, res);
    }
}
