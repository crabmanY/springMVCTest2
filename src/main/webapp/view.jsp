<%--
  Created by IntelliJ IDEA.
  User: crabman
  Date: 2018/5/21
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <table border="1">
        <tr>
            <td>标签</td>
            <td>值</td>
        </tr>
        <tr>
            <td>角色编号</td>
            <td><c:out value="${role.id}"></c:out></td>
        </tr>
        <tr>
            <td>角色名称</td>
            <td><c:out value="${role.rolename}"></c:out></td>
        </tr>
        <tr>
            <td>角色备注</td>
            <td><c:out value="${role.note}"></c:out></td>
        </tr>
    </table>

</div>
</body>
</html>
