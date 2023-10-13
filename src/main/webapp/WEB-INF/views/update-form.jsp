<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 06.10.2023
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/update/${st.id}" method="post">
    <label for="companyname">companyname</label>
    <input type="text" name="companyname" id="companyname" value="${st.companyname}">
    <label>Located</label>
    <input type="text" name="located" id="located" value="${st.locatedcountry}">
    <input type="submit" value="update">        
</form>
</body>
</html>