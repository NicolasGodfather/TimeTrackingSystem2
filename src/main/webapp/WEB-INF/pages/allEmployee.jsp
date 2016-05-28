<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8"?>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>All Employees</title>
</head>
<body>
<div class="container">
    <jsp:include page="topNavigationButtons.jsp" flush="true"/>
    <h1><p class="text-center">All Employees</p></h1>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Last Name</th>
            <th>Position</th>
        </tr>
        </thead>
        <thbody>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.firstName}</td>
                    <td>${employee.lastName}</td>
                    <td>${employee.position}</td>
                    <td>
                        <p>
                            <a class="btn btn-danger btn-xs" href="/delete/purse/${purse.id}" role="button">delete</a>
                            <a class="btn btn-default btn-xs" href="/save/purse/${purse.id}" role="button">edit</a>
                        </p>
                    </td>
                </tr>
            </c:forEach>
        </thbody>
    </table>
</div>

</body>
</html>
