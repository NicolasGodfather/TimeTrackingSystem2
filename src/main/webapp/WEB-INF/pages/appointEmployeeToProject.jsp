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

        <table class="table">
            <thead>
            <tr>
                <th>Full Name</th>
                <th>Actions</th>
            </tr>
            </thead>
            <c:forEach var="employee" items="${employees}">
                <thbody>
                    <tr>
                        <td>${employee.name}+" "+${employee.surname}</td>
                        <td>
                            <p>
                                <a class="btn btn-info btn-xs" href="/appoint/employee/${employee.id}" role="button">Appoint</a>
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


