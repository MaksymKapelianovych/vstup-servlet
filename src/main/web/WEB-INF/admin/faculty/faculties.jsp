<%@include file="/fragment/directive.jsp"%>
<html>
<head>
    <%@include file="/fragment/head.jsp"%>
    <title><fmt:message key="faculty.title"/> </title>
</head>
<body>
<%@include file="/fragment/header.jsp"%>
<%@include file="/fragment/admin-links.jsp"%>
<main>
    <table class="table table-hover">
        <thead>
            <tr>
                <th scope="col"><fmt:message key="faculty.name"/></th>
                <th scope="col"><fmt:message key="faculty.max.budget.places"/></th>
                <th scope="col"><fmt:message key="faculty.max.places"/></th>
                <th scope="col"><fmt:message key="faculty.active"/></th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="faculty" items="${requestScope.faculties}">
            <tr>
                <td scope="row">${faculty.getNameByLocale(sessionScope.locale)}</td>
                <td>${faculty.maxBudgetPlace}</td>
                <td>${faculty.maxPlace}</td>
                <td>${faculty.active ? 'Active' : 'Closed'}</td>
                <td><a class="btn btn-outline-primary" href="/admin/faculty/edit-faculty-page?faculty_id=${faculty.id}"><fmt:message key="edit.faculty"/></a></td>
                <td>
                    <c:if test="${faculty.active}">
                        <a class="btn btn-outline-primary" href="/admin/faculty/delete-faculty?faculty_id=${faculty.id}"><fmt:message key="delete.faculty"/></a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a class="btn btn-outline-success" href="/admin/faculty/add-faculty-page"><fmt:message key="add.faculty"/></a>
</main>
</body>
</html>
