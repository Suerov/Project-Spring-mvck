<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 06.10.2023
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2px">
    <th>Company table</th>
    <th>Course table</th>
    <th>Group table</th>
    <th>Student table</th>
    <th>Teacher table</th>
    <tr>
        <td>
            <button>
                <a href="/table">
                    Company table
                </a>
            </button>
        </td>
        <td>
            <button>
                <a href="/course/controller/">
                    Course table
                </a>
            </button>
        </td>
        <td>
            <button>
                <a href="/group/controller/">
                    Group table
                </a>
            </button>
        </td>
        <td>
            <button>
                <a href="/student/controller/">
                    Student table
                </a>
            </button>
        </td>
        <td>
            <button>
                <a href="/teacher/controller/">
                    Teacher table
                </a>
            </button>
        </td>
    </tr>

</table>
</body>
</html>