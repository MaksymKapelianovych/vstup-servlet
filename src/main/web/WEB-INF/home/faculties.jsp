<%@include file="../directive/directive.jsp"%>
<html>
<head>
    <title><fmt:message key="faculty.title"/> </title>
</head>
<body>
    <%@include file="../directive/header.jsp"%>
    <table class="searchable sortable">
    <thead>
        <tr>
            <td><fmt:message key="faculty.name"/></td>
            <td><fmt:message key="faculty.max.budget.places"/></td>
            <td><fmt:message key="faculty.max.places"/></td>
            <td></td>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="faculty" items="${requestScope.faculties}">
            <tr>
                <td>${faculty.getNameByLocale(sessionScope.locale)}</td>
                <td>${faculty.maxBudgetPlace}</td>
                <td>${faculty.maxPlace}</td>
                <td><a href="/home/home/add-request?faculty_id=${faculty.id}"><fmt:message key="add.request"/></a></td>
            </tr>
        </c:forEach>
    </tbody>
    </table>
</body>
</html>
