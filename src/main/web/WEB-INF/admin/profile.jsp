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

</div>
<div>
    <a href="/admin/faculty"><fmt:message key="faculty.list"/> </a>
    <a href="/admin/entrant"><fmt:message key="entrant.list"/></a>
    <a href="/admin/request"><fmt:message key="request.list"/></a>
</div>
</body>
</html>
