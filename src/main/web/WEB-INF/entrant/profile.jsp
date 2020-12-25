<%@include file="../directive/directive.jsp"%>
<html>
<head>
    <title><fmt:message key="profile.title"/></title>
</head>
<body>
    <%@include file="../directive/header.jsp"%>
    <div>
        <b>${sessionScope.entrant_info.name}</b>
        <b>${sessionScope.entrant_info.email}</b>
        <b>${sessionScope.entrant_info.school.getNameByLocale(sessionScope.locale)}</b>
        <b>${sessionScope.entrant_info.school.getCityByLocale(sessionScope.locale)}</b>
        <b>${sessionScope.entrant_info.school.region.getNameByLocale(sessionScope.locale)}</b>
    </div>
    <div>
        <b>${sessionScope.entrant_info.requirementInfo.firstSubject.name.getNameByLocale(sessionScope.locale)}</b>
        <b>${sessionScope.entrant_info.requirementInfo.firstSubject.rate}</b>
    </div>
    <div>
        <b>${sessionScope.entrant_info.requirementInfo.secondSubject.name.getNameByLocale(sessionScope.locale)}</b>
        <b>${sessionScope.entrant_info.requirementInfo.secondSubject.rate}</b>
    </div>
    <div>
        <b>${sessionScope.entrant_info.requirementInfo.thirdSubject.name.getNameByLocale(sessionScope.locale)}</b>
        <b>${sessionScope.entrant_info.requirementInfo.thirdSubject.rate}</b>
    </div>
    <c:if test="${sessionScope.entrant_info.requirementInfo.fourthSubject != null}">
        <div>
            <b>${sessionScope.entrant_info.requirementInfo.fourthSubject.name.getNameByLocale(sessionScope.locale)}</b>
            <b>${sessionScope.entrant_info.requirementInfo.fourthSubject.rate}</b>
        </div>
    </c:if>
    <c:if test="${sessionScope.entrant_info.requirementInfo.fifthSubject != null}">
        <div>
            <b>${sessionScope.entrant_info.requirementInfo.fifthSubject.name.getNameByLocale(sessionScope.locale)}</b>
            <b>${sessionScope.entrant_info.requirementInfo.fifthSubject.rate}</b>
        </div>
    </c:if>
    <div>
        <a href="/entrant/request"><fmt:message key="request.list"/></a>
    </div>
</body>
</html>
