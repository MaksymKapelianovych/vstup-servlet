<%@ page import="ua.vstup.constantutils.Url" %>
<%@ page import="ua.vstup.constantutils.Parameter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="directive/directive.jsp"%>
<html>
<head>
    <title><fmt:message key="login.title"/> </title>
</head>
<body>
<p>
    <form class="login-form" action="<%= Url.LOGIN_REDIRECT%>" method="post">
        <div>
            <input class="input" type="email" name="<%= Parameter.EMAIL%>" placeholder="<fmt:message key="input.email"/>">
            <input class="input" type="password" name="<%= Parameter.PASSWORD%>" placeholder="<fmt:message key="input.password"/>">
            <button type="submit"><fmt:message key="login.button"/> </button>
            <a href="<%=Url.REGISTER_FORWARD%>"><fmt:message key="register.button"/></a>
        </div>
    </form>
</p>
</body>
</html>
