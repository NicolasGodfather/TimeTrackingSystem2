<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Record Spent Time</title>
    <jsp:include page="setupPage.jsp" flush="true"/>
</head>
<body>
<div class="container">
    <jsp:include page="topNavigationButtons.jsp" flush="true"/>
    <h1><p class="text-center">Save Record Spent Time</p></h1>
    <form:form method="post" action="/save/project" commandName="spentTimeForm">
        <form:input class="form-control" id="id" path="id" value="${spentTimeForm.id}" type="hidden"/>

        <label>Number Of Hour</label><br/>
        <div class="form-group">
            <form:input class="form-control" id="numberOfHour" path="numberOfHour" placeholder="Number Of Hour"
                        value="${spentTimeForm.numberOfHour}"/>
            <form:errors path="numberOfHour" cssStyle="color: #ff0000;"/>
        </div>

        <input class="btn btn-success btn-xs" type="submit" value="save">
        <a class="btn btn-default btn-xs" href="/all/spentTime" role="button">cancel</a>
    </form:form>
</div>
</body>
</html>

