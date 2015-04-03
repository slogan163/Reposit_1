<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 30.03.2015
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Поиск по таблице</title>
</head>
<body>
  <%@include file="../top.jsp"%>

  Выбрана таблица: ${table}
  <p>Выберете атрибут:</p>

  <c:set var="table" value="${table}"></c:set>

  <c:if test="${table == 'Группа'}">
    <p>
      <form name="searchGroup" action="secondSearchServlet" method="get">
        <select size="1" name="selectAtributs">
          <option selected value="group_id">ИД группы</option>
          <option value="group_name">Наименование группы</option>
          <option value="head_id">ID Старосты</option>
        </select>
        <br>
        <input type="submit" value="Выбрать">
      </form>
    </p>
  </c:if>

  <c:if test="${table == 'Студент'}">
    <p>
    <form name="searchStudent" action="secondSearchServlet" method="get">
      <select size="1" name="selectAtributs">
        <option selected value="stud_id">ID студента</option>
        <option value="fname">Имя</option>
        <option value="lname">Фамилия</option>
        <option value="st_group_id">ID Группы</option>
      </select>
      <br>
     <input type="submit" value="Выбрать">
    </form>
    </p>
  </c:if>

</body>
</html>
