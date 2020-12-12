<%@ page import="ua.vstup.domain.Entrant" %>
<%@ page import="ua.vstup.constantutils.Url" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../directive/directive.jsp"%>
<html>
<head>
    <title><fmt:message key="profile.title"/> </title>
</head>
<body>
<a href= <%= Url.LOGOUT_REDIRECT%> ><fmt:message key="logout.button"/></a>
</body>
</html>
