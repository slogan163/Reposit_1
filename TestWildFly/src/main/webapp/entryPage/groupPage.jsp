<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список групп</title>
</head>
<body>
  <%@include file="../top.jsp"%>

  <p>${message}</p>

  <table border="1">
    <tr>
      <td>Наименование группы</td>
      <td>Курс</td>
      <td>Студенты группы</td>
      <td>Изменить</td>
      <td>Удалить</td>
    </tr>

    <c:forEach items="${groups}" var="group">
      <tr>
        <td>${group.name}</td>
        <td>${group.course}</td>
        <td><a href=<c:url value="/studentInGroupServlet">
                <c:param name="group_id" value="${group.id}"></c:param>
               </c:url>>Студенты группы</a></td>
        <td><a href=<c:url value="/updatePage/updateGroupPage.jsp">
                      <c:param name="group_id" value="${group.id}"></c:param>
                      <c:param name="group_name" value="${group.name}"></c:param>
                      <c:param name="course" value="${group.course}"></c:param>
                    </c:url>>Изменить</a></td>
        <td><a href=<c:url value="/deleteGroupServlet">
                      <c:param name="group_id" value="${group.id}"></c:param>
                    </c:url>>Удалить</a></td>
      </tr>
    </c:forEach>
  </table>

  <p>
  <form action="/TestWildFly-1.0-SNAPSHOT/createPage/createGroupPage.jsp" method="get">
    <input type="submit" name="submit" value="Добавить группу">
  </form>
  </p>
  <p>
  Запись групп в файл xml<br>
      <form action="/TestWildFly-1.0-SNAPSHOT/writeGroupServlet" method="get">
          <input type="text" name="file_name" value="имя файла" required>
          <input type="submit" value="записать группы в xml">
      </form>
  </p>
  <p>
  Чтение файла групп xml<br>
  <form enctype="multipart/form-data" method="POST" action="/TestWildFly-1.0-SNAPSHOT/readGroupServlet">
      <input type="file" name="file" size="1">
      <input type="submit" value="Отправить">
  </form>
  </p>
</body>
</html>
