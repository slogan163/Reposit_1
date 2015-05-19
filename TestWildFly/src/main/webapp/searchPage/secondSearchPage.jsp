<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Поиск по таблице</title>
</head>
<body>
  <%@include file="../top.jsp"%>

  <p>Введите параметры поиска:</p>

  <c:set var="table" value="${pageContext.session.getAttribute('selectTable')}"></c:set>

  <c:if test="${table == 'Группа'}">
    <form name="groupForm" action="/TestWildFly-1.0-SNAPSHOT/secondSearchServlet">
      <br>
      Наименование группы
      <p><input type="text" name="group_name"></p>
      Курс
      <p><input type="number" name="course" min="1" max="4"></p>
      <input type="submit" name="submit_group" value="поиск">
    </form>
  </c:if>

  <c:if test="${table == 'Студент'}">
    <form name="studentFrom" action="/TestWildFly-1.0-SNAPSHOT/secondSearchServlet">
      <br>
      Имя
      <p><input type="text" name="fname"></p>
      Фамилия
      <p><input type="text" name="lname"></p>
      Группа
      <p><input type="text" name="group_name"></p>
      <input type="submit" name="submit_student" value="ввести">
    </form>
  </c:if>
</body>
</html>
