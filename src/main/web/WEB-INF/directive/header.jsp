<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="ua.vstup.constantutils.Url" %>
<%@ page import="ua.vstup.constantutils.Parameter" %>
<%@ page import="ua.vstup.constantutils.Attribute" %>
<header>
    <div>
        <c:if test="${sessionScope.entrant!=null}">
            <a href="<%= Url.HOME_FORWARD%>"><fmt:message key="profile.button"/></a>
        </c:if>
        <a href="?<%=Parameter.LANGUAGE%>=<%=Attribute.EN%>">EN</a>
        <a href="?<%=Parameter.LANGUAGE%>=<%=Attribute.UA%>">UA</a>
        <c:if test="${sessionScope.entrant!=null}">
            <a href="<%= Url.LOGOUT_REDIRECT%>"><fmt:message key="logout.button"/></a>
        </c:if>
    </div>
</header>