<%@ taglib prefix="frm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="ua.vstup.domain.Entrant" %>
<%@ page import="ua.vstup.constantutils.Url" %>
<%@include file="../directive/directive.jsp"%>
<html>
<head>
    <title><fmt:message key="profile.title"/> </title>
</head>
<body>
    <%@include file="../directive/header.jsp"%>
    <fmt:message key="request.list"/>
    <c:forEach var="request" items="${requestScope.requests}">
        <div>
            <tr>
                <td>${request.faculty.getNameByLocale(sessionScope.locale)}</td>
                <td>${request.firstSubject.name.getNameByLocale(sessionScope.locale)}</td>
                <td>${request.secondSubject.name.getNameByLocale(sessionScope.locale)}</td>
                <td>${request.thirdSubject.name.getNameByLocale(sessionScope.locale)}</td>
                <td>${request.state.getNameByLocale(sessionScope.locale)}</td>
            </tr>
        </div>
    </c:forEach>
</body>
</html>
