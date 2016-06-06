<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Project</title>
    <jsp:include page="setupPage.jsp" flush="true"/>
</head>
<body>
<div class="container">
    <jsp:include page="topNavigationButtons.jsp" flush="true"/>
    <h1><p class="text-center">Save Project</p></h1>
    <form:form method="post" action="/save/project" commandName="projectForm">
        <form:input class="form-control" id="id" path="id" value="${projectForm.id}" type="hidden"/>
        <form:input class="form-control" id="responsibleEmployeeId"  value="${responsibleEmployeeId}" type="hidden"/>
        <div class="form-group">
            <label>Project Name</label><br/>
            <form:input class="form-control" id="projectName" path="projectName" placeholder="Project Name"
                        value="${projectForm.projectName}"/>
            <form:errors path="projectName" cssStyle="color: #ff0000;"/>
        </div>
        <div>
            <label>Appoint Employee</label>
            <form:select path="responsibleEmployeeId" class="form-control">
                <c:forEach var="responsibleEmployee" items="${responsibleEmployeeId}">
                    <option value="${currency.id}">${currency.name}</option>
                </c:forEach>
            </form:select>
        </div>
        <input class="btn btn-success btn-xs" type="submit" value="save">
        <a class="btn btn-default btn-xs" href="/all/project" role="button">cancel</a>
    </form:form>
</div>
</body>
</html>

