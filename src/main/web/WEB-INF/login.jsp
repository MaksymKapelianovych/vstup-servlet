<%@ include file="directive/directive.jsp"%>
<html>
<head>
    <title><fmt:message key="login.title"/> </title>
</head>
<body>
<%@include file="directive/header.jsp"%>
<p>
    <form class="login-form" action="/login" method="post">
        <div>
            <input class="input" type="email" name="email" placeholder="<fmt:message key="input.email"/>">
            <input class="input" type="password" name="password" placeholder="<fmt:message key="input.password"/>">
            <button type="submit"><fmt:message key="login.button"/> </button>
            <a href="/register-page"><fmt:message key="register.button"/></a>
        </div>
    </form>
</p>
</body>
</html>
