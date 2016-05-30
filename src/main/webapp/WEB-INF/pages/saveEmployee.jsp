<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Employee</title>
    <jsp:include page="setupPage.jsp" flush="true"/>
</head>
<body>
<div class="container">
    <jsp:include page="topNavigationButtons.jsp" flush="true"/>
    <h1><p class="text-center">Save Employee</p></h1>
    <form:form method="post" action="/save/employee" commandName="employeeForm">
        <form:input class="form-control" id="id" path="id" value="${employeeForm.id}" type="hidden"/>
        <label>Name</label><br/>

        <div class="form-group">
            <form:input class="form-control" id="firstName" path="firstName" placeholder="Name"
                        value="${employeeForm.name}"/>
            <form:errors path="firstName" cssStyle="color: #ff0000;"/>
        </div>
        <label>Last Name</label><br/>

        <div class="form-group">
            <form:input class="form-control" id="lastName" path="lastName" placeholder="Last Name"
                        value="${employeeForm.surname}"/>
            <form:errors path="lastName" cssStyle="color: #ff0000;"/>
        </div>
        <input class="btn btn-success btn-xs" type="submit" value="save">

        <label>Position</label><br/>

        <div class="form-group">
            <form:input class="form-control" id="position" path="position" placeholder="Position"
                        value="${employeeForm.position}"/>
            <form:errors path="position" cssStyle="color: #ff0000;"/>
        </div>
        <input class="btn btn-success btn-xs" type="submit" value="save">
        <a class="btn btn-default btn-xs" href="/" role="button">cancel</a>
    </form:form>
</div>
</body>
</html>

