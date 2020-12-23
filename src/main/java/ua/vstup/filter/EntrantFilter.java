package ua.vstup.filter;

import ua.vstup.constantutils.Constants;
import ua.vstup.domain.Entrant;
import ua.vstup.domain.Role;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {Constants.Urls.ENTRANT + "/*"})
public class EntrantFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
        if(servletResponse.isCommitted()){
            return;
        }

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        if(session != null){
            Entrant obj = (Entrant)session.getAttribute(Constants.Attributes.ENTRANT);
            if(obj != null && obj.getRole() == Role.ADMIN){
                response.sendRedirect(Constants.Urls.ADMIN_FACULTY_FORWARD);
            }else{
                filterChain.doFilter(request, response);
            }
        }
    }
}
