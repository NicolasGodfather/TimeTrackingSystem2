<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Task</title>
    <jsp:include page="setupPage.jsp" flush="true"/>
</head>
<body>
<div class="container">
    <jsp:include page="topNavigationButtons.jsp" flush="true"/>
    <h1><p class="text-center">Save Task</p></h1>
    <form:form method="post" action="/save/task" commandName="taskForm">
        <form:input class="form-control" id="id" path="id" value="${taskForm.id}" type="hidden"/>

        <label>Task Name</label><br/>
        <div class="form-group">
            <form:input class="form-control" id="taskName" path="taskName" placeholder="Task Name"
                        value="${taskForm.taskName}"/>
            <form:errors path="name" cssStyle="color: #ff0000;"/>
        </div>

        <input class="btn btn-success btn-xs" type="submit" value="save">
        <a class="btn btn-default btn-xs" href="/all/task" role="button">cancel</a>
    </form:form>
</div>
</body>
</html>

