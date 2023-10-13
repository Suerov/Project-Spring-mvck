<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 08.10.2023
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/course/controller/save" method="post">
    <label for="coursename">coursename:</label><input type="text" name="coursename" id="coursename">
    <label for="duration">duration:</label><input type="text" name="duration" id="duration">
    <c:forEach items="${find}" var="com">
        <label id="${com.id}">${com.companyname}</label>
        <input type="checkbox" value="${com.id}" name="company_id">
    </c:forEach>

    <input type="submit" value="save">

</form>

</body>
</html>
