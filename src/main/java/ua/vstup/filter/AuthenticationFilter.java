package ua.vstup.filter;

import ua.vstup.constantutils.Constants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(urlPatterns = {Constants.Urls.ENTRANT + "/*", Constants.Urls.ADMIN + "/*"})
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        if (!(session != null && (session.getAttribute(Constants.Attributes.ENTRANT) != null))) {
            response.sendRedirect(Constants.Urls.LOGIN_FORWARD);
        }

        if(response.isCommitted()){
            return;
        }

        filterChain.doFilter(request, response);

    }
}