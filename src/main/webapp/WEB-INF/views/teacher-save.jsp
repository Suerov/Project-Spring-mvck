<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11.10.2023
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/teacher/controller/save" method="post">
    <label for="email">email:</label><input type="text" name="email" id="email">
    <label for="firstname">firstname:</label><input type="text" name="firstname" id="firstname">
    <label for="lastname">lastname:</label><input type="text" name="lastname" id="lastname">
    <input type="submit" value="save">
    <c:forEach items="${finds}" var="coms">
        <label id="${coms.id}">${coms.coursename}</label>
        <input type="checkbox" value="${coms.id}" name="course_id">
    </c:forEach>
</form>

</body>
</html>
