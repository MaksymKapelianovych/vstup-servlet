<%@include file="../../directive/directive.jsp"%>
<html>
<head>
    <title><fmt:message key="edit.faculty.title"/></title>
</head>
<body>
<%@include file="../../directive/header.jsp"%>
<form class="add-faculty-form" action="/admin/faculty/add-faculty" method="post">
    <div>
        <input type="text" name="name_en" placeholder="<fmt:message key="faculty.name.en"/>" value="${requestScope.faculty.name_en}"/>
        <input type="text" name="name_ua" placeholder="<fmt:message key="faculty.name.ua"/>" value="${requestScope.faculty.name_ua}"/>
        <input type="text" name="maxBudgetPlaces" placeholder="<fmt:message key="faculty.max.budget.places"/>" value="${requestScope.faculty.maxBudgetPlace}"/>
        <input type="text" name="maxPlaces" placeholder="<fmt:message key="faculty.max.places"/>" value="${requestScope.faculty.maxPlace}">
    </div>
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
                <c:forEach var="subject_name" items="${requestScope.subjectNames}">
                    <option value="${subject_name}" label="${subject_name.getNameByLocale(sessionScope.locale)}"></option>
                </c:forEach>
            </datalist>
        </div>
    </div>
    <button type="submit"><fmt:message key="register.button"/></button>
    <a href="/admin/faculty"><fmt:message key="back"/></a>
</form>
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
