<%@include file="../../directive/directive.jsp"%>
<html>
<head>
    <title><fmt:message key="faculty.title"/> </title>
</head>
<body>
<%@include file="../../directive/header.jsp"%>
<table class="searchable sortable">
    <thead>
    <tr>
        <td><fmt:message key="faculty.name"/></td>
        <td><fmt:message key="faculty.max.budget.places"/></td>
        <td><fmt:message key="faculty.max.places"/></td>
        <td><fmt:message key="faculty.active"/></td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="faculty" items="${requestScope.faculties}">
        <tr>
            <td>${faculty.getNameByLocale(sessionScope.locale)}</td>
            <td>${faculty.maxBudgetPlace}</td>
            <td>${faculty.maxPlace}</td>
            <td>${faculty.active ? 'Active' : 'Closed'}</td>
            <td><a href="/admin/faculty/edit-faculty-page?faculty_id=${faculty.id}"><fmt:message key="edit.faculty"/></a></td>
            <c:if test="${faculty.active}">
                <td>
                    <a href="/admin/faculty/delete-faculty?faculty_id=${faculty.id}"><fmt:message key="delete.faculty"/></a>
                </td>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>
</table>
    <a href="/admin/faculty/add-faculty-page"><fmt:message key="add.faculty"/></a>
</body>
</html>
