package ua.vstup.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static ua.vstup.constantutils.url.Url.ROOT;
import static ua.vstup.constantutils.url.Url.LOGIN_FORWARD;

@WebFilter(urlPatterns = {ROOT + "/*"})
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        if (!(session != null && (session.getAttribute("entrant") != null))) {
            response.sendRedirect(LOGIN_FORWARD);
        }else {
            filterChain.doFilter(request, response);
        }
    }
}