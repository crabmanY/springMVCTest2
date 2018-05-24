<%--
  Created by IntelliJ IDEA.
  User: crabman
  Date: 2018/5/24
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("id",5);
    //转发给控制器
    request.getRequestDispatcher("/attribute/requestAttribute").forward(request,response);

%>
</body>
</html>
