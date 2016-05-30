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
    <p align="right"><a class="btn btn-info btn-xs" href="//add/employee" role="button">add employee</a></p>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Last Name</th>
            <th>Position</th>
        </tr>
        </thead>
        <c:forEach var="employee" items="${employees}">
            <thbody>
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.name}</td>
                    <td>${employee.surname}</td>
                    <td>${employee.position}</td>
                    <td>
                        <p>
                            <a class="btn btn-danger btn-xs" href="/delete/employee/${employee.id}" role="button">delete</a>
                            <a class="btn btn-default btn-xs" href="/save/employee/${employee.id}" role="button">edit</a>
                        </p>
                    </td>
                </tr>
            </thbody>
        </c:forEach>
    </table>
</div>

</body>
</html>
