<%--
  Created by IntelliJ IDEA.
  User: crabman
  Date: 2018/5/24
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
session.setAttribute("id","15");
response.sendRedirect("/attribute/sessionAttribute");
%>


</body>
</html>
