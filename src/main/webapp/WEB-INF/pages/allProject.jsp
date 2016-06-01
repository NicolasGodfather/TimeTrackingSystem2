<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>All Projects</title>
    <jsp:include page="setupPage.jsp" flush="true"/>
</head>
<body>
<div class="container">
    <jsp:include page="topNavigationButtons.jsp" flush="true"/>
    <h1><p class="text-center">All Projects</p></h1>
    <p align="center"><a class="btn btn-sm btn-success" href="/add/project" role="button">Add Projects</a></p>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name Project</th>
            <th>Responsible Employee</th>
            <th>List Task</th>
            <th>Actions</th>
        </tr>
        </thead>
        <c:forEach var="project" items="${projects}">
            <thbody>
                <tr>
                    <td>${project.id}</td>
                    <td>${project.projectName}</td>
                    <td>${project.responsibleEmployeeDTO.name} ${project.responsibleEmployeeDTO.surname}</td>
                    <td><a href="all/tasks/${project.taskDTOs}" role="button">View tasks</a></td>
                    <td>
                        <p>
                            <a class="btn btn-info btn-xs" href="/project/appoint/employee/{id}${project.id}" role="button">Appoint</a>
                            <a class="btn btn-xs btn-default" href="/save/project/${project.id}" role="button">Edit</a>
                            <a class="btn btn-xs btn-danger" href="/delete/project/${project.taskDTOs}" role="button">Delete</a>
                        </p>
                    </td>
                </tr>
            </thbody>
        </c:forEach>
    </table>
</div>

</body>
</html>
