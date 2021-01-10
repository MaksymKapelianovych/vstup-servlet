<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<header>
    <div>
        <c:if test="${sessionScope.entrant_info != null}">
            <c:choose>
                <c:when test="${sessionScope.entrant_info.role.name() == 'ADMIN'}">
                    <a href="/admin/profile"><fmt:message key="profile.button"/></a>
                </c:when>
                <c:otherwise>
                    <a href="/entrant/profile"><fmt:message key="profile.button"/></a>
                </c:otherwise>
            </c:choose>
        </c:if>
        <a href="?language=en">EN</a>
        <a href="?language=ua">UA</a>
    </div>

    <c:if test="${sessionScope.entrant_info!=null}">
        <a href="/logout"><fmt:message key="logout.button"/></a>
    </c:if>
</header>