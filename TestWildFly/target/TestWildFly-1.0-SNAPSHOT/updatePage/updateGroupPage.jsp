<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменение группы</title>
</head>
<body>
  <%@include file="/top.jsp"%>

  <p>Изменение группы</p>
  <form name="groupForm" action="/TestWildFly-1.0-SNAPSHOT/updateGroupServlet">
    <br>
    Наименование группы
    <p><input type="text" name="group_name" required value=<%=request.getParameter("group_name")%>></p>
    Курс
    <p><input type="number" name="course" value=<%=request.getParameter("course")%> required min="1" max="4"></p>
    <input type="hidden" name="group_id" value=<%=request.getParameter("group_id")%>>
    <input type="submit" name="submit_group" value="Изменить">
  </form>
</body>
</html>
