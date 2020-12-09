package ua.vstup.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@WebFilter("/*")
public class SessionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if (req.getSession(false) == null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("date", LocalDate.now());
            session.setAttribute("page", 1);
            session.setAttribute("locale", "en");
        }
        filterChain.doFilter(req, res);
    }
}
