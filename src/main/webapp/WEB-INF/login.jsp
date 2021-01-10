<%@ include file="fragment/directive.jsp"%>
<html>
<head>
    <%@include file="/WEB-INF/fragment/head.jsp"%>
    <title><fmt:message key="login.title"/> </title>
</head>
<body>
<%@include file="fragment/header.jsp"%>
<main>
    <form class="login-form" action="/login" method="post">
        <label><fmt:message key="login.title"/></label>
        <input class="input form-control" type="email" name="email" placeholder="<fmt:message key="input.email"/>">
        <input class="input form-control" type="password" name="password" placeholder="<fmt:message key="input.password"/>">
        <div class="buttons">
            <button class="btn btn-outline-primary" type="submit"><fmt:message key="login.button"/> </button>
            <a class="btn btn-success" href="/register-page"><fmt:message key="register.button"/></a>
        </div>
    </form>
</main>
</body>
</html>
