<%@include file="../directive/directive.jsp"%>
<html>
<head>
    <title><fmt:message key="profile.title"/> </title>
</head>
<body>
    <%@include file="../directive/header.jsp"%>
    <table>
        <thead>
            <tr>
                <td><fmt:message key="faculty.name"/></td>
                <td><fmt:message key="subject.name"/></td>
                <td><fmt:message key="subject.name"/></td>
                <td><fmt:message key="subject.name"/></td>
                <td><fmt:message key="request.state"/></td>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="request" items="${requestScope.requests}">
                <tr>
                    <td>${request.faculty.getNameByLocale(sessionScope.locale)}</td>
                    <td>${request.firstSubject.name.getNameByLocale(sessionScope.locale)}</td>
                    <td>${request.firstSubject.rate}</td>
                    <td>${request.secondSubject.name.getNameByLocale(sessionScope.locale)}</td>
                    <td>${request.secondSubject.rate}</td>
                    <td>${request.thirdSubject.name.getNameByLocale(sessionScope.locale)}</td>
                    <td>${request.thirdSubject.rate}</td>
                    <td>${request.state.getNameByLocale(sessionScope.locale)}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div>
        <a href="/entrant/faculty"><fmt:message key="faculty.list"/></a>
    </div>
    <div>
        <a href="/entrant/request/add-request"><fmt:message key="add.request"/></a>
    </div>
</body>
</html>
