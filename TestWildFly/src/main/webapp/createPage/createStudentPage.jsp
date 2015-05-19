<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление студента</title>
</head>
<body>
  <%@include file="/top.jsp"%>
  <p>Введите данные студента</p>

  <form name="studentFrom" action="/TestWildFly-1.0-SNAPSHOT/createSecondStudentServlet">
    <br>
    Имя
    <p><input type="text" name="fname" required="имя"></p>
    Фамилия
    <p><input type="text" name="lname" required="фамилия"></p>

    <p>Выберете группу</p>
    <p><select name="group" required>
      <c:forEach items="${groups}" var="group">
        <option value="${group.id}">${group.name}</option>
      </c:forEach>
    </select></p>
    <input type="submit" value="Добавить студента">
  </form>
</body>
</html>
