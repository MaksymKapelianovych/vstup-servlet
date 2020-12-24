
<%@include file="../directive/directive.jsp"%>
<html>
<head>
    <title><fmt:message key="add.request"/></title>
</head>
<body>
    <%@include file="../directive/header.jsp"%>
    <div>
        <b>${requestScope.faculty_info.getNameByLocale(sessionScope.locale)}</b>
    </div>
    <form class="request-form" action="/entrant/request/add-request" method="post">
        <div>
            <div>
                <input class="input_subject" list="subjectNames" name="subject_name1"/>
                <input class="input" type="number" name="subject_rate1">
            </div>
            <div>
                <input class="input_subject" list="subjectNames" name="subject_name2"/>
                <input class="input" type="number" name="subject_rate2">
            </div>
            <div>
                <input class="input_subject" list="subjectNames" name="subject_name3"/>
                <input class="input" type="number" name="subject_rate3">
            </div>
            <div>
                <input class="input_subject" list="subjectNames" name="subject_name4"/>
                <input class="input" type="number" name="subject_rate4">
            </div>
            <div>
                <input class="input_subject" list="subjectNames" name="subject_name5"/>
                <input class="input" type="number" name="subject_rate5">
            </div>
            <div>
                <datalist id="subjectNames">
                    <c:forEach var="subject_name" items="${requestScope.faculty_info.requirementInfo.subjectList}">
                        <option value="${subject_name}" label="${subject_name.name().getNameByLocale(sessionScope.locale)}"></option>
                    </c:forEach>
                </datalist>
            </div>
</body>
</html>
