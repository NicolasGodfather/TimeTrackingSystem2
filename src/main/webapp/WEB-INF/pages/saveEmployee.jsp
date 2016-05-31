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
            <form:input class="form-control" id="name" path="name" placeholder="Name"
                        value="${employeeForm.name}"/>
            <form:errors path="name" cssStyle="color: #ff0000;"/>
        </div>

        <label>Surname</label><br/>
        <div class="form-group">
            <form:input class="form-control" id="surname" path="surname" placeholder="Surname"
                        value="${employeeForm.surname}"/>
            <form:errors path="surname" cssStyle="color: #ff0000;"/>
        </div>

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

