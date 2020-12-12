<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="ua.vstup.constantutils.Url" %>
<%@ page import="ua.vstup.constantutils.Parameter" %>
<%@ page import="ua.vstup.constantutils.Attribute" %>
<header>
    <div>
        <a href="<%= Url.HOME_FORWARD%>"><fmt:message key="profile.button"/></a>
        <a href="?<%=Parameter.LANGUAGE%>=<%=Attribute.EN%>">EN</a>
        <a href="?<%=Parameter.LANGUAGE%>=<%=Attribute.UA%>">UA</a>
        <a href="<%= Url.LOGOUT_REDIRECT%>"><fmt:message key="logout.button"/></a>
    </div>
</header>