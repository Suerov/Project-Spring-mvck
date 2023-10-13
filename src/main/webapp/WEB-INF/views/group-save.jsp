<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 09.10.2023
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/group/controller/save" method="post">>
    <label for="dateoffinish">dateoffisnish:</label><input type="text" name="dateoffinsih" id="dateoffinish">
    <label for="dateofstart">dateofstart:</label><input type="text" name="dateofstart" id="dateofstart">
    <label for="groupname">groupname:</label><input type="text" name="groupname" id="groupname">
    <c:forEach items="${find}" var="com">
        <label id="${com.id}">${com.companyname}</label>
        <input type="checkbox" value="${com.id}" name="company_id">
    </c:forEach>
    <c:forEach items="${finds}" var="com">
        <label id="${com.id}">${com.coursename}</label>
        <input type="checkbox" value="${com.id}" name="course_id">
    </c:forEach>

    <input type="submit" value="save">

</form>

</body>
</html>
