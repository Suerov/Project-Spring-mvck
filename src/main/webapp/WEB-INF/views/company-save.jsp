<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 03.10.2023
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/save" method="post">
    <label for="companyName">companyName:</label><input type="text" name="companyName" id="companyName">
    <label for="locatedCountry">locatedCountry:</label><input type="text" name="locatedCountry" id="locatedCountry">
    <input type="submit" value="save">
</form>
</body>
</html>
