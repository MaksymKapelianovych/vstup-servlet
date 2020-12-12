package ua.vstup.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class CharsetFilter implements Filter {
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        encoding = filterConfig.getInitParameter("requestEncoding");
//        if(encoding == null){
//            encoding = "UTF-16";
//        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        if(servletRequest.getCharacterEncoding() == null){
//            servletRequest.setCharacterEncoding(encoding);
//        }
//
//        servletResponse.setContentType("text/html; charset=UTF-16");
//        servletResponse.setCharacterEncoding("UTF-16");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
