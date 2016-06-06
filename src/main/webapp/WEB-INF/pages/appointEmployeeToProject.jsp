<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <jsp:include page="topNavigationButtons.jsp" flush="true"/>
    <h1><p class="text-center">Appoint Project To Employee</p></h1>
    <form:form method="post" action="/employee/appoint/project/{id}${responsibleEmployeeId}" commandName="projectForm">
        <form:input class="form-control" id="id" path="id" type="hidden"/>
        <form:input class="form-control" id="responsibleEmployeeId" path="responsibleEmployeeId" value="${responsibleEmployeeId}" type="hidden"/>
        <div class="form-group">
            <label>Project Name</label>
            <form:input class="form-control" id="projectName" path="projectName" placeholder="Project Name" value="${projectForm.projectName}"/>
            <form:errors path="projectName" cssStyle="color: #ff0000;"/>
        </div>

        <div>
            <label>Responsible Employee</label>
            <form:select path="responsibleEmployeeId" class="form-control">
                <c:forEach var="responsibleEmployee" items="${employees}">
                    <option value="${responsibleEmployee.id}">${responsibleEmployee.name}</option>
                </c:forEach>
            </form:select>
        </div>

        <input class="btn btn-success btn-xs" type="submit" value="save">
        <a class="btn btn-default btn-xs" href="/" role="button">cancel</a>
    </form:form>
    </form>
</div>
</body>
</html>
