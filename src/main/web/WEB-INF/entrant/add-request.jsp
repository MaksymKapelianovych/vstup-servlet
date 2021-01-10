<%@include file="/fragment/directive.jsp"%>
<html>
<head>
    <%@include file="/fragment/head.jsp"%>
    <title><fmt:message key="add.request"/></title>
</head>
<body>
    <%@include file="/fragment/header.jsp"%>
    <%@include file="/fragment/entrant-links.jsp"%>

    <div>
        <b>${requestScope.faculty_info.getNameByLocale(sessionScope.locale)}</b>
    </div>
    <form class="request-form" action="/entrant/request/add-request?faculty_id=${requestScope.faculty_info.id}" method="post">
        <div>
            <div>
                <input class="input_subject" list="subjectNames" name="subject_id1"/>
            </div>
            <div>
                <input class="input_subject" list="subjectNames" name="subject_id2"/>
            </div>
            <div>
                <input class="input_subject" list="subjectNames" name="subject_id3"/>
            </div>
            <div>
                <datalist id="subjectNames">
                    <c:forEach var="subject_name" items="${requestScope.subjects}">
                        <option value="${subject_name.id}" label="${subject_name.name.getNameByLocale(sessionScope.locale)}, ${subject_name.rate}"></option>
                    </c:forEach>
                </datalist>
            </div>
        </div>
        <div class="buttons">
            <button class="btn btn-outline-primary" type="submit"><fmt:message key="add.request"/></button>
            <a class="btn btn-success" href="/entrant/request"><fmt:message key="back"/></a>
        </div>
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
