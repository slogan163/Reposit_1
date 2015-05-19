<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Поиск по таблице</title>
</head>

<body>
<%@include file="../top.jsp"%>

<p><h3>Поиск значения по таблице</h3></p>
Выберете таблицу:
<br>
<form name="searchTable" action="/TestWildFly-1.0-SNAPSHOT/firstSearchServlet" method="get">
  <p><select size="1" name="selectTable">
    <option selected value="Группа">Группа</option>
    <option value="Студент">Студент</option>
  </select></p>
  <p><input type="submit" name="submit" value="Далее"></p>
</form>
</body>

</html>