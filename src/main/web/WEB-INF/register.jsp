<%@ page import="ua.vstup.constantutils.Parameter" %>
<%@ page import="ua.vstup.constantutils.Url" %>

<%@ include file="directive/directive.jsp"%>
<html>
<head>
    <title><fmt:message key="register.title"/></title>
</head>
<body>
    <%@include file="directive/header.jsp"%>
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
                        <option value="${subject_name}">${subject_name.getNameByLocale(sessionScope.locale)}</option>
                    </c:forEach>
                </datalist>
            </div>
            <div>
            <input class="input" type="text" name="<%= Parameter.NAME%>" placeholder="<fmt:message key="input.name"/>"/>
            <input class="input" type="email" name="<%= Parameter.EMAIL%>>" placeholder="<fmt:message key="input.email"/>"/>
            <input class="input" type="password" name="<%= Parameter.PASSWORD%>>" placeholder="<fmt:message key="input.password"/>"/>
            <input class="input" list="schools" name="<%= Parameter.SCHOOL_ID%>>" placeholder="<fmt:message key="choose.school"/>"/>
                <datalist id="schools">
                    <c:forEach var="school" items="${requestScope.schools}">
                        <option value="${school.id}">${school.getNameByLocale(sessionScope.locale)}, ${school.getCityByLocale(sessionScope.locale)}, ${school.region.getNameByLocale(sessionScope.locale)}</option>
                    </c:forEach>
                </datalist>
            </div>
            <button type="submit"><fmt:message key="register.button"/></button>
            <a href="<%= Url.LOGIN_FORWARD%>"><fmt:message key="back.to.login"/></a>
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
