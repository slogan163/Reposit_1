<%@ page import="java.util.List" %>
<%@ page import="servlestDB.Group" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 02.04.2015
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Результат поиска</title>
</head>
<body>
  <%@include file="../top.jsp"%>

  <p>Результат: </p>

  <c:if test="${table == 'Группа'}">
    <table>
      <tr>
        <td>ИД группы</td>
        <td>Наименование группы</td>
        <td>ИД Старосты</td>
      </tr>

      <c:forEach items="${groups}" var="group">
        <tr>
          <td>${group.group_id}</td>
          <td>${group.group_name}</td>
          <td>${group.head_id}</td>
        </tr>
      </c:forEach>
    </table>
  </c:if>

  <c:if test="${table == 'Студент'}">
    <table>
      <tr>
        <td>ИД Студента</td>
        <td>Имя</td>
        <td>Фамилия</td>
        <td>ИД Группы</td>
      </tr>

      <c:forEach items="${students}" var="student">
        <tr>
          <td>${student.stud_id}</td>
          <td>${student.fname}</td>
          <td>${student.lname}</td>
          <td>${student.st_group_id}</td>
        </tr>
      </c:forEach>
    </table>
  </c:if>

</body>
</html>
