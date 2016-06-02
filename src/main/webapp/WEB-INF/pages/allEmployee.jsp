<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>All Employees</title>
    <jsp:include page="setupPage.jsp" flush="true"/>
</head>
<body>
<div class="container">
    <jsp:include page="topNavigationButtons.jsp" flush="true"/>
    <h1><p class="text-center">All Employees</p></h1>
    <p align="center"><a class="btn btn-sm btn-success" href="/add/employee" role="button">Add Employee</a></p>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Position</th>
            <th>Actions</th>
        </tr>
        </thead>
        <c:forEach var="employee" items="${employees}">
            <thbody>
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.name}</td>
                    <td>${employee.surname}</td>
                    <td>${employee.position}</td>
                    <td>${employee.}</td>
                    <td>${employee.position}</td>
                    <td>
                        <p>
                            <a class="btn btn-info btn-xs" href="/project/appoint/employee/{id}${employee.id}" role="button">Appoint</a>
                            <a class="btn btn-xs btn-default" href="/save/employee/${employee.id}" role="button">Edit</a>
                            <a class="btn btn-xs btn-danger" href="/delete/employee/${employee.id}" role="button">Delete</a>
                        </p>
                    </td>
                </tr>
            </thbody>
        </c:forEach>
    </table>
</div>

</body>
</html>
