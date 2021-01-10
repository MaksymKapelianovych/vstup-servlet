<%@include file="/fragment/directive.jsp"%>
<html>
<head>
    <%@include file="/fragment/head.jsp"%>
    <title><fmt:message key="entrant.title"/></title>
</head>
<body>
    <%@include file="/fragment/header.jsp"%>
    <%@include file="/fragment/admin-links.jsp"%>
    <main>
    <table class="table table-hover">
        <thead>
            <tr>
                <th scope="col"><fmt:message key="entrant.name"/></th>
                <th scope="col"><fmt:message key="entrant.email"/></th>
                <th scope="col"><fmt:message key="entrant.active"/></th>
            </tr>
        <tbody>
        <c:forEach var="entrant" items="${requestScope.entrants}">
            <tr>
                <td scope="row">${entrant.name}</td>
                <td>${entrant.email}</td>
                <c:choose>
                    <c:when test="${entrant.active}">
                        <td><fmt:message key="enabled"/> </td>
                        <td><a class="btn btn-outline-primary" href="/admin/entrant/disable?entrant_id=${entrant.id}"><fmt:message key="disable"/> </a></td>
                    </c:when>
                    <c:otherwise>
                        <td><fmt:message key="disabled"/> </td>
                        <td><a class="btn btn-outline-primary" href="/admin/entrant/enable?entrant_id=${entrant.id}"><fmt:message key="enable"/> </a></td>
                    </c:otherwise>
                </c:choose>

            </tr>
        </c:forEach>
        </tbody>
        </thead>
    </table>
    <a class="btn btn-success" href="/admin/entrant"><fmt:message key="back"/> </a>
</main>
</body>
</html>
