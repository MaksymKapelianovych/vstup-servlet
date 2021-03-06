<%@include file="/WEB-INF/fragment/directive.jsp"%>
<html>
<head>
    <%@include file="/WEB-INF/fragment/head.jsp"%>
    <link href="/src/main/webapp/assests/css/input-form.css" rel="stylesheet">
    <title><fmt:message key="faculty.title"/> </title>
</head>
<body>
    <%@include file="/WEB-INF/fragment/header.jsp"%>
    <%@include file="/WEB-INF/fragment/entrant-links.jsp"%>

    <main>
        <table class="table table-hover">
        <thead>
            <tr>
                <th scope="col"><fmt:message key="faculty.name"/></th>
                <th scope="col"><fmt:message key="faculty.max.budget.places"/></th>
                <th scope="col"><fmt:message key="faculty.max.places"/></th>
                <th scope="col"></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="faculty" items="${requestScope.faculties}">
                <tr>
                    <td scope="row">${faculty.getNameByLocale(sessionScope.locale)}</td>
                    <td>${faculty.maxBudgetPlace}</td>
                    <td>${faculty.maxPlace}</td>
                    <td><a href="/entrant/request/add-request-page?faculty_id=${faculty.id}"><fmt:message key="add.request"/></a></td>
                </tr>
            </c:forEach>
        </tbody>
        </table>
    </main>
</body>
</html>
