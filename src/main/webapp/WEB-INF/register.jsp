<%@ include file="/WEB-INF/fragment/directive.jsp"%>
<html>
<head>
    <%@include file="/WEB-INF/fragment/head.jsp"%>
    <title><fmt:message key="register.title"/></title>
</head>
<body>
    <%@include file="/WEB-INF/fragment/header.jsp"%>
    <main>
    <form class="input-form" action="register" method="post">
        <div class="main-info">

            <div class="input-group">
                <input class="input form-control" type="email" name="email" placeholder="<fmt:message key="input.email"/>"/>
                <input class="input form-control" type="password" name="password" placeholder="<fmt:message key="input.password"/>"/>
            </div>
            <div class="input-group">
                <input class="input form-control" type="text" name="name" placeholder="<fmt:message key="input.name"/>"/>
                <input class="input form-control" list="schools" name="school_id" placeholder="<fmt:message key="choose.school"/>"/>
                <datalist id="schools">
                    <c:forEach var="school" items="${requestScope.schools}">
                        <option value="${school.id}">${school.getNameByLocale(sessionScope.locale)}, ${school.getCityByLocale(sessionScope.locale)}, ${school.region.getNameByLocale(sessionScope.locale)}</option>
                    </c:forEach>
                </datalist>
            </div>
        </div>
        <div class="subjects-group">
            <label><fmt:message key="subject.rate"/></label>
            <div class="input-group">
                <input class="input_subject form-control" list="subjectNames" name="subject_name1"/>
                <input class="input form-control" type="number" name="subject_rate1">
            </div>
            <div class="input-group">
                <input class="input_subject form-control" list="subjectNames" name="subject_name2"/>
                <input class="input form-control" type="number" name="subject_rate2">
            </div>
            <div class="input-group">
                <input class="input_subject form-control" list="subjectNames" name="subject_name3"/>
                <input class="input form-control" type="number" name="subject_rate3">
            </div>
            <div>
                <datalist id="subjectNames">
                    <c:forEach var="subject_name" items="${requestScope.subjectNames}">
                        <option value="${subject_name}" label="${subject_name.getNameByLocale(sessionScope.locale)}"></option>
                    </c:forEach>
                </datalist>
            </div>

            <div class="buttons">
                <button class="btn btn-outline-primary" type="submit"><fmt:message key="register.button"/></button>
                <a class="btn btn-success" href="/"><fmt:message key="back.to.login"/></a>
            </div>

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
