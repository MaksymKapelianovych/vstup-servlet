
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
                    <c:forEach var="subject_name" items="${sessionScope.entrant_info.requirementInfo.subjectList}">
                        <option value="${subject_name.id}" label="${subject_name.name.getNameByLocale(sessionScope.locale)}, ${subject_name.rate}"></option>
                    </c:forEach>
                </datalist>
            </div>
        </div>
        <button type="submit"><fmt:message key="add.request"/></button>
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
