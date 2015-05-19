<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 12.05.2015
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создание группы</title>
</head>
<body>
  <%@include file="/top.jsp"%>
  <p>Создание группы</p>
  <form name="groupForm" action="/TestWildFly-1.0-SNAPSHOT/createGroupServlet">
    <br>
    Наименование группы
    <p><input type="text" name="group_name" required="группа"></p>
    Курс
    <p><input type="number" name="course" required="1" min="1" max="4"></p>
    <input type="submit" name="submit_group" value="Добавить">
  </form>
</body>
</html>
