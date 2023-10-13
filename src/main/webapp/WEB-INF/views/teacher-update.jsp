<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11.10.2023
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/teacher/controller/update/${st.id}" method="post">
    <label for="email">email</label>
    <input type="text" name="email" id="email" value="${st.email}">
    <label for="firstname">firstname</label>
    <input type="text" name="firstname" id="firstname" value="${st.firstname}">
    <label for="lastname">lastname</label>
    <input type="text" name="lastname" id="lastname" value="${st.lastname}">
    <input type="submit" value="update">

</form>

</body>
</html>
