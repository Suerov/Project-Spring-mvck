<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 10.10.2023
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/student/controller/update/${sd.id}" method="post">
    <label for="email">email</label>
    <input type="text" name="email" id="email" value="${sd.email}">
    <label for="lastname">lastname</label>
    <input type="text" name="lastname" id="lastname" value="${sd.lastname}">
    <label for="firstname">firstname</label>
    <input type="text" name="firstname" id="firstname" value="${sd.firstname}">
    <label for="studentformat">studentformat</label>
    <input type="text" name="studentformat" id="studentformat" value="${sd.studentformat}">
    <input type="submit" value="update">
</form>
</body>
</html>
