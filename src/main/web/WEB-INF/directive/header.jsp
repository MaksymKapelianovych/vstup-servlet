<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<header>
    <div>
        <c:if test="${sessionScope.entrant!=null}">
            <a href="/entrant/profile"><fmt:message key="profile.button"/></a>
        </c:if>
        <a href="?language=en">EN</a>
        <a href="?language=ua">UA</a>
        <c:if test="${sessionScope.entrant!=null}">
            <a href="/logout"><fmt:message key="logout.button"/></a>
        </c:if>
    </div>
</header>