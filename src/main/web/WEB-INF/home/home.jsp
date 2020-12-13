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
                <td>${request.facultyId}</td>
                <td>${request.firstSubjectId}</td>
                <td>${request.secondSubjectId}</td>
                <td>${request.thirdSubjectId}</td>
                <td>${request.state.getNameByLocale(sessionScope.locale)}</td>
            </tr>
        </div>
    </c:forEach>
</body>
</html>
