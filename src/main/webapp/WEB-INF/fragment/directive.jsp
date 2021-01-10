<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"
         errorPage="/WEB-INF/error.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="locale/message"/>
<!DOCTYPE html>