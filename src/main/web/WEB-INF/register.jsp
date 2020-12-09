<%--
  Created by IntelliJ IDEA.
  User: zephyrus
  Date: 09.12.20
  Time: 07:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register new entrant</title>
</head>
<body>
    <form class="login-form" action="register" method="post">
        <div>
            <div>
                <input class="input" type="text" name="subject_name1">
                <input class="input" type="number" name="subject_rate1">
            </div>
            <div>
            <input class="input" type="text" name="subject_name2">
            <input class="input" type="number" name="subject_rate2">
            </div>
            <div>
            <input class="input" type="text" name="subject_name3">
            <input class="input" type="number" name="subject_rate3">
            </div>
            <div>
            <input class="input" type="text" name="subject_name4">
            <input class="input" type="number" name="subject_rate4">
            </div>
            <div>
                <input class="input" type="text" name="subject_name5">
            <input class="input" type="number" name="subject_rate5">
            </div>
            <div>
            <input class="input" type="text" name="name">
            <input class="input" type="email" name="email">
            <input class="input" type="password" name="password">
            <input class="input" type="number" name="school_id">
            </div>
            <button type="submit">Submit</button>
        </div>
    </form>
</body>
</html>
