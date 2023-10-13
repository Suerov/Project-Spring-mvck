<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 08.10.2023
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2px">
    <th>Courses ID:</th>
    <th>Courses:</th>
    <th>Duration:</th>
    <th>Delete:</th>
    <th>Update:</th>
    <c:forEach items="${p}" var="h">
        <tr>
            <td>
                <a href="find/by/${h.id}">
                    ${h.id}</a>
            </td>
            <td>${h.coursename}</td>
            <td>${h.duration}</td>
        <td>
            <button>
                    <a href="delete/${h.id}">
                        DELETE
                    </a>
                </button>
            </td>
            <td>
                <button>
                    <a href="update/form/${h.id}">
                        UPDATE
                    </a>
                </button>
            </td>

        </tr>
    </c:forEach>
</table>
<button>
    <a href="save/form">
        Register Course
    </a>
</button>
</table>

</body>
</html>
