<%@include file="/WEB-INF/fragment/directive.jsp"%>
<html>
<head>
    <%@include file="/WEB-INF/fragment/head.jsp"%>
    <title><fmt:message key="statement.title"/></title>
</head>
<body>
<%@include file="/WEB-INF/fragment/header.jsp"%>
<%@include file="/WEB-INF/fragment/admin-links.jsp"%>
<main>
    <div>
        <c:choose>
            <c:when test="${requestScope.statement == null}">
                <a class="btn btn-outline-primary" href="/admin/statement/add-statement"><fmt:message key="add.statement"/></a>
            </c:when>
            <c:otherwise>
                <a class="btn btn-outline-primary" href="/admin/statement/finalize"><fmt:message key="finalize.statement"/></a>
            </c:otherwise>
        </c:choose>
    </div>
</main>
</body>
</html>
