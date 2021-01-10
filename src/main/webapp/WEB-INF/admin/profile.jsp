<%@include file="/WEB-INF/fragment/directive.jsp"%>
<html>
<head>
    <%@include file="/WEB-INF/fragment/head.jsp"%>

    <title><fmt:message key="profile.title"/></title>
</head>
<body>
<%@include file="/WEB-INF/fragment/header.jsp"%>
<%@include file="/WEB-INF/fragment/admin-links.jsp"%>
<div>
    <b>${sessionScope.entrant_info.name}</b>
    <b>${sessionScope.entrant_info.email}</b>
</div>
</body>
</html>
