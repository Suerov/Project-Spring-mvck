<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 10.10.2023
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/student/controller/save" method="post">
    <label for="email">email:</label><input type="text" name="email" id="email">
    <label for="lastname">lastname:</label><input type="text" name="lastname" id="lastname">
    <label for="firstname">firstname:</label><input type="text" name="firstname" id="firstname">
    <label for="studentformat">studentformat:</label><input type="text" name="studentformat" id="studentformat">
    <input type="submit" value="save">
    <c:forEach items="${find}" var="coms">
        <label id="${coms.id}">${coms.groupname}</label>
        <input type="checkbox" value="${coms.id}" name="group_id">
    </c:forEach>
</form>
</body>
</html>
