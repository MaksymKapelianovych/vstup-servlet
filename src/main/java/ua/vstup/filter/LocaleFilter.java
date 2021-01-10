package ua.vstup.filter;



import ua.vstup.constantutils.Constants;

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
        String locale = req.getParameter(Constants.Parameters.LANGUAGE);
        final HttpSession session = req.getSession(false);

        if (session != null){
            Object currentLocale = session.getAttribute(Constants.Attributes.LOCALE);

            if (currentLocale == null) {
                if (locale == null) {
                    session.setAttribute(Constants.Attributes.LOCALE, Constants.Attributes.EN);
                } else {
                    //LOGGER.info(String.format("Locale filter set locale to %s", locale));
                    session.setAttribute(Constants.Attributes.LOCALE, locale);
                }
            } else if (locale != null && !currentLocale.toString().equals(locale)) {
                // LOGGER.info(String.format("Locale filter set locale to %s", locale));
                session.setAttribute(Constants.Attributes.LOCALE, locale);
            }

        }

        filterChain.doFilter(req, res);
    }
}
