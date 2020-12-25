<%@include file="../../directive/directive.jsp"%>
<html>
<head>
    <title><fmt:message key="profile.title"/></title>
</head>
<body>
    <%@include file="../../directive/header.jsp"%>
    <table>
        <thead>
            <tr><fmt:message key="entrant.name"/></tr>
            <tr><fmt:message key="faculty.name"/></tr>
            <tr><fmt:message key="subject.name"/></tr>
            <tr><fmt:message key="subject.rate"/></tr>
            <tr><fmt:message key="subject.name"/></tr>
            <tr><fmt:message key="subject.rate"/></tr>
            <tr><fmt:message key="subject.name"/></tr>
            <tr><fmt:message key="subject.rate"/></tr>
            <tr><fmt:message key="request.state"/></tr>
        </thead>
        <tbody>
        <c:forEach var="request" items="${requestScope.requests}">
            <tr>
                <td>${request.entrantName}</td>
                <td>${request.getFacultyNameByLocale(sessionScope.locale)}</td>
                <td>${request.firstSubject.name.getNameByLocale(sessionScope.locale)}</td>
                <td>${request.firstSubject.rate}</td>
                <td>${request.secondSubject.name.getNameByLocale(sessionScope.locale)}</td>
                <td>${request.secondSubject.rate}</td>
                <td>${request.thirdSubject.name.getNameByLocale(sessionScope.locale)}</td>
                <td>${request.thirdSubject.rate}</td>
                <td>${request.state}</td>
                <c:if test="${request.state == 'ACTIVE'}">
                    <td><a href="/admin/request/accept?request_id=${request.id}"><fmt:message key="request.accept"/> </a></td>
                    <td><a href="/admin/request/disable?request_id=${request.id}"><fmt:message key="request.disable"/> </a></td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
