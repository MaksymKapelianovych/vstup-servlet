<%@include file="/WEB-INF/fragment/directive.jsp"%>
<html>
<head>
    <%@include file="/WEB-INF/fragment/head.jsp"%>

    <title><fmt:message key="profile.title"/></title>
</head>
<body>
    <%@include file="/WEB-INF/fragment/header.jsp"%>
    <%@include file="/WEB-INF/fragment/admin-links.jsp"%>
    <main>
    <table class="table table-hover">
        <thead>
            <tr>
                <th scope="col"><fmt:message key="entrant.name"/></th>
                <th scope="col"><fmt:message key="faculty.name"/></th>
                <th scope="col"><fmt:message key="subject.name"/></th>
                <th scope="col"><fmt:message key="subject.rate"/></th>
                <th scope="col"><fmt:message key="subject.name"/></th>
                <th scope="col"><fmt:message key="subject.rate"/></th>
                <th scope="col"><fmt:message key="subject.name"/></th>
                <th scope="col"><fmt:message key="subject.rate"/></th>
                <th scope="col"><fmt:message key="request.state"/></th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="request" items="${requestScope.requests}">
            <tr>
                <td scope="row">${request.entrant.name}</td>
                <td>${request.faculty.getNameByLocale(sessionScope.locale)}</td>
                <td>${request.firstSubject.name.getNameByLocale(sessionScope.locale)}</td>
                <td>${request.firstSubject.rate}</td>
                <td>${request.secondSubject.name.getNameByLocale(sessionScope.locale)}</td>
                <td>${request.secondSubject.rate}</td>
                <td>${request.thirdSubject.name.getNameByLocale(sessionScope.locale)}</td>
                <td>${request.thirdSubject.rate}</td>
                <td>${request.state}</td>
                <c:if test="${request.state == 'ACTIVE'}">
                    <td><a class="btn btn-outline-primary" href="/admin/request/accept?request_id=${request.id}"><fmt:message key="request.accept"/> </a></td>
                    <td><a class="btn btn-outline-primary" href="/admin/request/disable?request_id=${request.id}"><fmt:message key="request.disable"/> </a></td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
</body>
</html>
