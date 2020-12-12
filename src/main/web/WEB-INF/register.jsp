<%@ page import="ua.vstup.constantutils.Parameter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <input class="input_subject" list="subjectNames" name="<%= Parameter.SUBJECT_NAME1%>"/>
                <input class="input" type="number" name="<%= Parameter.SUBJECT_RATE1%>">
            </div>
            <div>
                <input class="input_subject" list="subjectNames" name="<%= Parameter.SUBJECT_NAME2%>"/>
                <input class="input" type="number" name="<%= Parameter.SUBJECT_RATE2%>">
            </div>
            <div>
                <input class="input_subject" list="subjectNames" name="<%= Parameter.SUBJECT_NAME3%>"/>
                <input class="input" type="number" name="<%= Parameter.SUBJECT_RATE3%>">
            </div>
            <div>
                <input class="input_subject" list="subjectNames" name="<%= Parameter.SUBJECT_NAME4%>"/>
                <input class="input" type="number" name="<%= Parameter.SUBJECT_RATE4%>">
            </div>
            <div>
                <input class="input_subject" list="subjectNames" name="<%= Parameter.SUBJECT_NAME5%>"/>
                <input class="input" type="number" name="<%= Parameter.SUBJECT_RATE5%>">
            </div>
            <div>
                <datalist id="subjectNames">
                    <c:forEach var="subject_name" items="${requestScope.subjectNames}">
                        <option value="${subject_name}">${subject_name}</option>
                    </c:forEach>
                </datalist>
            </div>
            <div>
            <input class="input" type="text" name="name"/>
            <input class="input" type="email" name="email"/>
            <input class="input" type="password" name="password"/>
            <input class="input" list="schools" name="school_id"/>
                <datalist id="schools">
                    <c:forEach var="school" items="${requestScope.schools}">
                        <option value="${school.id}">${school.name}, ${school.city}, ${school.region}</option>
                    </c:forEach>
                </datalist>
            </div>
            <button type="submit">Submit</button>
        </div>
    </form>
<script>
    const inputs = Array.from(document.querySelectorAll(".input_subject"))
    document.querySelectorAll(".input_subject").forEach((input) => input.addEventListener("change", (event) => {
        inputs.forEach((i) => {
            if(input !== i) {
                if (input.value === i.value) {
                    input.value = ""
                }
            }
        })
    }))
</script>
</body>
</html>
