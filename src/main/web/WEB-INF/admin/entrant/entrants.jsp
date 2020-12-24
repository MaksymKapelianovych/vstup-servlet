<%@include file="../../directive/directive.jsp"%>
<html>
<head>
    <title><fmt:message key="entrant.title"/></title>
</head>
<body>
    <%@include file="../../directive/header.jsp"%>
    <table class="searchable sort-order">
        <thead>
        <tr>
            <td><fmt:message key="entrant.name"/></td>
            <td><fmt:message key="entrant.email"/></td>
            <td><fmt:message key="entrant.active"/></td>
        </tr>
        <tbody>
        <c:forEach var="entrant" items="${requestScope.entrants}">
            <tr>
                <td>${entrant.name}</td>
                <td>${entrant.email}</td>
                <c:choose>
                    <c:when test="${entrant.active}">
                        <td><fmt:message key="enabled"/> </td>
                        <td><a href="/admin/entrant/disable?entrant_id=${entrant.id}"><fmt:message key="disable"/> </a></td>
                    </c:when>
                    <c:otherwise>
                        <td><fmt:message key="disabled"/> </td>
                        <td><a href="/admin/entrant/enable?entrant_id=${entrant.id}"><fmt:message key="enable"/> </a></td>
                    </c:otherwise>
                </c:choose>

            </tr>
        </c:forEach>
        </tbody>
        </thead>
    </table>
    <a href="/admin/entrant"><fmt:message key="back"/> </a>
</body>
</html>
