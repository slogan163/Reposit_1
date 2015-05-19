<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список студентов</title>
</head>
<body>
<%@include file="../top.jsp"%>

<p>${message}</p>
<table border="1">
  <tr>
    <td>Имя</td>
    <td>Фамилия</td>
    <td>Группа</td>
    <td>Изменить</td>
    <td>Удалить</td>
  </tr>
  <c:forEach items="${students}" var="student">
    <tr>
      <td>${student.name}</td>
      <td>${student.lastName}</td>
      <td><a href=<c:url value="/groupForStudent">
              <c:param name="group_id" value="${student.groupID}"></c:param>
             </c:url>>Группа</a></td>
      <td><a href=<c:url value="/updateStudentServlet">
        <c:param name="stud_id" value="${student.id}"></c:param>
        <c:param name="fname" value="${student.name}"></c:param>
        <c:param name="lname" value="${student.lastName}"></c:param>
        <c:param name="st_group_id" value="${student.groupID}"></c:param>
        </c:url>>Изменить</a></td>
      <td><a href=<c:url value="/deleteStudentServlet">
        <c:param name="stud_id" value="${student.id}"></c:param>
        </c:url>>Удалить</a></td>
    </tr>
  </c:forEach>
</table>

  <p>
  <form action="/TestWildFly-1.0-SNAPSHOT/createFirstStudentServlet" method="get">
    <input type="submit" value="Добавить студента">
  </form>
  </p>
  <p>
    Запись студентов в файл xml<br>
  <form action="/TestWildFly-1.0-SNAPSHOT/writeStudentServlet" method="get">
    <input type="text" name="file_name" value="имя файла" required>
    <input type="submit" value="записать студентов в xml">
  </form>
  </p>
  <p>
    Чтение файла студентов xml<br>
  <form enctype="multipart/form-data" method="POST" action="/TestWildFly-1.0-SNAPSHOT/readStudentServlet">
    <input type="file" name="file" size="1">
    <input type="submit" value="Отправить">
  </form>
  </p>
</body>
</html>
