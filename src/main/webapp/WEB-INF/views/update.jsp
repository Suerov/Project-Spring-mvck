<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 08.10.2023
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/course/controller/updates/${sf.id}" method="post">
    <label for="coursename">coursename</label>
    <input type="text" name="coursename" id="coursename" value="${sf.coursename}">
    <input type="text" name="duration" id="duration" value="${sf.duration}">
    <input type="submit" value="update">
</form>

</body>
</html>
