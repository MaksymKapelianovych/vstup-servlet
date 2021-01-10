<%@include file="/fragment/directive.jsp"%>
<html>
<head>
    <%@include file="/fragment/head.jsp"%>
    <link href="/styles/input-form.css" rel="stylesheet">
    <title><fmt:message key="edit.faculty.title"/></title>
</head>
<body>
<%@include file="/fragment/header.jsp"%>
<%@include file="/fragment/admin-links.jsp"%>
<main>
    <form class="input-form" action="/admin/faculty/edit-faculty" method="post">
        <div class="input-group">
            <input class="input form-control" type="text" name="name_en" placeholder="<fmt:message key="faculty.name.en"/>" value="${requestScope.faculty_info.name_en}"/>
            <input class="input form-control" type="text" name="name_ua" placeholder="<fmt:message key="faculty.name.ua"/>" value="${requestScope.faculty_info.name_ua}"/>
        </div>
        <div class="input-group">
            <input class="input form-control" type="text" name="maxBudgetPlaces" placeholder="<fmt:message key="faculty.max.budget.places"/>" value="${requestScope.faculty_info.maxBudgetPlace}"/>
            <input class="input form-control" type="text" name="maxPlaces" placeholder="<fmt:message key="faculty.max.places"/>" value="${requestScope.faculty_info.maxPlace}"/>
        </div>
        <div class="subjects-group">
            <label><fmt:message key="subject.rate"/></label>

            <div class="input-group">
                <input class="input_subject form-control" list="subjectNames" name="subject_name1" value="${requestScope.faculty_info.requirementInfo.firstSubject.name.getNameByLocale(sessionScope.locale)}"/>
                <input class="input form-control" type="number" name="subject_rate1" value="${requestScope.faculty_info.requirementInfo.firstSubject.rate}"/>
            </div>
            <div class="input-group">
                <input class="input_subject form-control" list="subjectNames" name="subject_name2" value="${requestScope.faculty_info.requirementInfo.secondSubject.name.getNameByLocale(sessionScope.locale)}"/>
                <input class="input form-control" type="number" name="subject_rate2" value="${requestScope.faculty_info.requirementInfo.secondSubject.rate}"/>
            </div>
            <div class="input-group">
                <input class="input_subject form-control" list="subjectNames" name="subject_name3" value="${requestScope.faculty_info.requirementInfo.thirdSubject.name.getNameByLocale(sessionScope.locale)}"/>
                <input class="input form-control" type="number" name="subject_rate3" value="${requestScope.faculty_info.requirementInfo.thirdSubject.rate}"/>
            </div>
            <div class="input-group">
                <input class="input_subject form-control" list="subjectNames" name="subject_name4" value="${requestScope.faculty_info.requirementInfo.fourthSubject.name.getNameByLocale(sessionScope.locale)}"/>
                <input class="input form-control" type="number" name="subject_rate4" value="${requestScope.faculty_info.requirementInfo.fourthSubject.rate}"/>
            </div>
            <div class="input-group">
                <input class="input_subject form-control" list="subjectNames" name="subject_name5" value="${requestScope.faculty_info.requirementInfo.fifthSubject.name.getNameByLocale(sessionScope.locale)}"/>
                <input class="input form-control" type="number" name="subject_rate5" value="${requestScope.faculty_info.requirementInfo.fifthSubject.rate}"/>
            </div>
            <div>
                <datalist id="subjectNames">
                    <c:forEach var="subject_name" items="${requestScope.subjectNames}">
                        <option value="${subject_name}" label="${subject_name.getNameByLocale(sessionScope.locale)}"></option>
                    </c:forEach>
                </datalist>
            </div>
        </div>
        <div class="buttons">
            <button class="btn btn-outline-primary" type="submit"><fmt:message key="register.button"/></button>
            <a class="btn btn-success" href="/admin/faculty"><fmt:message key="back"/></a>
        </div>

    </form>
</main>
<script>
    const inputs = Array.from(document.querySelectorAll(".input_subject"))
    document.querySelectorAll(".input_subject").forEach((input) => input.addEventListener("change", (event) => {
        inputs.forEach((i) => {
            if(input !== i) {
                if (input.value === i.value) {
                    input.value = ""
                }
            }
        })
    }))
</script>
</body>
</html>
