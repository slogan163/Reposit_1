<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 02.04.2015
  Time: 7:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Поиск по таблице</title>
</head>
<body>
  <%@include file="../top.jsp"%>

  Выбран атрибут: ${atribute}
  <p>
    Введите значение атрибута:
    <form name="formAtribute" action="threeSearchServlet" method="get">
      <input type="text" name="text">
      <br>
      <input type="submit" name="ввести" value="ввести">
    </form>
  </p>
</body>
</html>
