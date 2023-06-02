<%--
  Created by IntelliJ IDEA.
  User: shinn
  Date: 30/05/2023
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
    <style>

        table, td{
            border: 1px solid gray;
            margin: 0 auto;
        }
        form {
            padding: 50px;
            margin: 0 auto;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        input {
            padding: 8px 20px;
        }
        button {
            padding: 10px 20px;
            border: none;
            background-color: black;
            color: white;
        }

    </style>
</head>
<body>
    <form action="<c:url value="/test"/>" method="POST">
<%--        <label>Path to save:</label>--%>
        <input type="text" name="filePath" placeholder="Path...">
        <button type="submit" value="Export excel file">Export excel file</button>
    </form>
    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Password</th>
        </tr>
        <c:forEach var="i" items="${list}">
            <tr>
                <td>${i.firstName}</td>
                <td>${i.lastName}</td>
                <td>${i.email}</td>
                <td>${i.password}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
