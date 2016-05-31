<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Appoint Employee To Project</title>
    <jsp:include page="setupPage.jsp" flush="true"/>
</head>
<body>
<div class="container">
    <jsp:include page="topNavigationButtons.jsp" flush="true"/>
    <h1><p class="text-center">Appoint Employee To Project</p></h1>
    <form:form method="post" action="/project/save/employee/{id}${projectId}" commandName="employeeForm">
        <form:input class="form-control" id="id" path="id" type="hidden"/>
        <form:input class="form-control" id="projectId" path="projectId" value="${projectId}" type="hidden"/>
        <div class="form-group">
            <label>Name</label>
            <form:input class="form-control" id="name" path="name" placeholder="Name" value="${employeeForm.name}"/>
            <form:errors path="name" cssStyle="color: #ff0000;"/>
        </div>
        <div>
            <label>Currency</label>
            <form:select path="currencyId" class="form-control">
                <c:forEach var="currency" items="${currencies}">
                    <option value="${currency.id}">${currency.name}</option>
                </c:forEach>
            </form:select>
        </div>
        <div class="form-group">
            <label>Amount</label>
            <form:input class="form-control" id="name" path="amount" placeholder="Amount"
                        value="${editPurse.amount}"/>
            <form:errors path="amount" cssStyle="color: #ff0000;"/>
        </div>

        <table class="table">
            <thead>
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Position</th>
                <th>Project</th>
                <th>Task</th>
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
                        <td><%--${employee.project}--%></td>
                        <td><%--${employee.task}--%></td>
                        <td>
                            <p>
                                <a class="btn btn-info btn-xs" href="/appoint/employee/${employee.id}" role="button">Appoint</a>
                                <a class="btn btn-xs btn-default" href="/save/employee/${employee.id}" role="button">Edit</a>
                                <a class="btn btn-xs btn-danger" href="/delete/employee/${employee.id}" role="button">Delete</a>
                            </p>
                        </td>
                    </tr>
                </thbody>
            </c:forEach>
        </table>
        <input class="btn btn-success btn-xs" type="submit" value="save">
        <a class="btn btn-default btn-xs" href="/" role="button">cancel</a>
    </form:form>
    </form>
</div>
</body>
</html>


