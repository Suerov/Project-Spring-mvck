<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 10.10.2023
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2px">
    <th>Teachers ID:</th>
    <th>Email:</th>
    <th>Firstname:</th>
    <th>Lastname:</th>
    <th>Delete:</th>
    <th>Update:</th>
    <c:forEach items="${d}" var="h">
        <tr>
            <td>
               <a href="find/by/${h.id}">
                    ${h.id} </a>

            </td>
            <td>${h.email}</td>
            <td>${h.firstname}</td>
            <td>${h.lastname}</td>
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
    <a href="/teacher/controller/save/form">
        Register Teacher
    </a>
</button>
</table>

</body>
</html>
