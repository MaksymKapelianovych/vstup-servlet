<%@include file="../fragment/directive.jsp"%>
<html>
<head>
    <%@include file="/fragment/head.jsp"%>
    <link href="/styles/input-form.css" rel="stylesheet">
    <title><fmt:message key="profile.title"/> </title>
</head>
<body>
    <%@include file="../fragment/header.jsp"%>
    <%@include file="/fragment/entrant-links.jsp"%>
    <main>
        <table class="table table-hover">
            <thead>
                <tr>
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
                        <td scope="row">${request.faculty.getNameByLocale(sessionScope.locale)}</td>
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
    </main>
</body>
</html>
