package ua.vstup.filter;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.vstup.constantutils.Attribute;
import ua.vstup.constantutils.Parameter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class LocaleFilter implements Filter {
    //private static final Logger LOGGER = LogManager.getLogger(LocaleFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String locale = req.getParameter(Parameter.LANGUAGE);
        final HttpSession session = req.getSession(false);

        if (session == null){
            return;
        }

        Object currentLocale = session.getAttribute(Attribute.LOCALE);

        if (currentLocale == null) {
            if (locale == null) {
                session.setAttribute(Attribute.LOCALE, Attribute.EN);
            } else {
                //LOGGER.info(String.format("Locale filter set locale to %s", locale));
                session.setAttribute(Attribute.LOCALE, locale);
            }
        } else if (locale != null && !currentLocale.toString().equals(locale)) {
           // LOGGER.info(String.format("Locale filter set locale to %s", locale));
            session.setAttribute(Attribute.LOCALE, locale);
        }

        filterChain.doFilter(req, res);
    }
}
