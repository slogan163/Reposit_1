<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменение параметров студента</title>
</head>
<body>
    <%@include file="/top.jsp"%>


    <form name="studentFrom" action="/TestWildFly-1.0-SNAPSHOT/updateFinishStudentServlet">
        <br>
        <input type="hidden" name="stud_id" value="${stud_id}">
        Имя
        <p><input type="text" name="fname" value="${fname}" required="имя"></p>
        Фамилия
        <p><input type="text" name="lname" value="${lname}" required="фамилия"></p>

        <p>Выберете группу</p>
        <p><select name="group" required>
            <c:forEach items="${groups}" var="group">
                <option value="${group.id}">${group.name}</option>
            </c:forEach>
        </select></p>
        <input type="submit" value="Изменить студента">
    </form>
</body>
</html>
