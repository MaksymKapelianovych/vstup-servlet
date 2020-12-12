<%@ page import="ua.vstup.constantutils.Url" %>
<%@ page import="ua.vstup.constantutils.Parameter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Test</h1>
<p>
    <form class="login-form" action="<%= Url.LOGIN_REDIRECT%>" method="post">
        <div>
            <input class="input" type="email" name="<%= Parameter.EMAIL%>">
            <input class="input" type="password" name="<%= Parameter.PASSWORD%>">
            <button type="submit">Submit</button>
            <a href="register-page">Register</a>
        </div>
    </form>
</p>
</body>
</html>
