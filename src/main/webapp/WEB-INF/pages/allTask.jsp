<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>All Tasks</title>
    <jsp:include page="setupPage.jsp" flush="true"/>
</head>
<body>
<div class="container">
    <jsp:include page="topNavigationButtons.jsp" flush="true"/>
    <h1><p class="text-center">All Tasks</p></h1>
    <%--<p align="center"><a class="btn btn-sm btn-success" href="/add/task" role="button">Add Task</a></p>--%>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name Task</th>
            <th>Responsible Employee</th>
            <th>Name Project</th>
            <th>List Record Spent Time</th>
            <th>Actions</th>
        </tr>
        </thead>
        <c:forEach var="task" items="${tasks}">
            <thbody>
                <tr>
                    <td>${task.id}</td>
                    <td>${task.taskName}</td>
                    <td>${task.responsibleEmployee.name} ${task.responsibleEmployee.surname}</td>
                    <td>${task.taskOfProject}</td>
                    <td><a href="all/spentTime/${task.spentTimeDTOs}" role="button">View All Records</a></td>
                    <td>
                        <p>
                            <a class="btn btn-info btn-xs" href="/appoint/task/${task.id}" role="button">Appoint</a>
                            <a class="btn btn-xs btn-default" href="/save/task/${task.id}" role="button">Edit</a>
                            <a class="btn btn-xs btn-danger" href="/delete/task/${task.id}" role="button">Delete</a>
                        </p>
                    </td>
                </tr>
            </thbody>
        </c:forEach>
    </table>
</div>

</body>
</html>
