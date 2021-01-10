<%@include file="/fragment/directive.jsp"%>
<html>
<head>
    <%@include file="/fragment/head.jsp"%>

    <title><fmt:message key="profile.title"/></title>
</head>
<body>
<%@include file="/fragment/header.jsp"%>
<%@include file="/fragment/admin-links.jsp"%>
<div>
    <b>${sessionScope.entrant_info.name}</b>
    <b>${sessionScope.entrant_info.email}</b>
</div>
</body>
</html>
