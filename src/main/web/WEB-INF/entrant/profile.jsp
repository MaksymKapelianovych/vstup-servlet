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
        <b>${sessionScope.entrant_info.requirementInfo.firstSubject.name.getNameByLocale(sessionScope.locale)}</b>
        <b>${sessionScope.entrant_info.requirementInfo.firstSubject.rate}</b>
    </div>
    <div>
        <b>${sessionScope.entrant_info.requirementInfo.firstSubject.name.getNameByLocale(sessionScope.locale)}</b>
        <b>${sessionScope.entrant_info.requirementInfo.firstSubject.rate}</b>
    </div>
    <div>
        <b>${sessionScope.entrant_info.requirementInfo.firstSubject.name.getNameByLocale(sessionScope.locale)}</b>
        <b>${sessionScope.entrant_info.requirementInfo.firstSubject.rate}</b>
    </div>
    <div>
        <b>${sessionScope.entrant_info.requirementInfo.firstSubject.name.getNameByLocale(sessionScope.locale)}</b>
        <b>${sessionScope.entrant_info.requirementInfo.firstSubject.rate}</b>
    </div>
    <div>
        <a href="entrant/request"><fmt:message key="request.list"/></a>
    </div>
</body>
</html>
