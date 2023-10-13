<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 09.10.2023
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/group/controller/updates/${st.id}" method="post">
    <label for="dateoffinish">dateoffinish</label>
    <input type="text" name="dateoffinish" id="dateoffinish" value="${st.dateoffinish}">
    <label for="dateofstart">dateofstart</label>
    <input type="text" name="dateofstart" id="dateofstart" value="${st.dateofstart}">
    <label for="groupname">groupname</label>
    <input type="text" name="groupname" id="groupname" value="${st.groupname}">
    <input type="submit" value="update">
</form>
</body>
</html>
