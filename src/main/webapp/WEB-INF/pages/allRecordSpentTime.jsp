<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>All Records Spent Time</title>
    <jsp:include page="setupPage.jsp" flush="true"/>
</head>
<body>
<div class="container">
    <jsp:include page="topNavigationButtons.jsp" flush="true"/>
    <h1><p class="text-center">All Records Spent Time</p></h1>
    <p align="center"><a class="btn btn-sm btn-success" href="/add/recordSpentTime" role="button">All Records Spent Time</a></p>
    <table class="table">
        <thead>
        <tr>
            <th>Name Task</th>
            <th>Full Name Employee</th>
            <th>Date of recording</th>
            <th>Number Of Hours</th>
            <th>Actions</th>
        </tr>
        </thead>
        <c:forEach var="recordSpentTime" items="${recordSpentTime}">
            <thbody>
                <tr>
                    <td>${recordSpentTime.employeeName}</td>
                    <td>${recordSpentTime.calendarInsertRecord}</td>
                    <td>${recordSpentTime.numberOfHour}</td>
                    <td>
                        <p>
                            <a class="btn btn-info btn-xs" href="/appoint/recordSpentTime/${recordSpentTime.id}" role="button">Appoint</a>
                            <a class="btn btn-xs btn-default" href="/save/recordSpentTime/${recordSpentTime.id}" role="button">Edit</a>
                            <a class="btn btn-xs btn-danger" href="/delete/recordSpentTime/${recordSpentTime.id}" role="button">Delete</a>
                        </p>
                    </td>
                </tr>
            </thbody>
        </c:forEach>
    </table>
</div>

</body>
</html>
