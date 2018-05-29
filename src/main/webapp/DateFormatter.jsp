<%--
  Created by IntelliJ IDEA.
  User: crabman
  Date: 2018/5/29
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="form" action="/converter/date">
    <table>
        <tr>
            <td>日期</td>
            <td><input id="date" name="date1"type="text" value="2018-05-29"></td>
        </tr>
        <tr>
            <td>金额</td>
            <td><input id="amount" name="amount1" type="text" value="123,000.00"></td>
        </tr>
        <tr>
            <td></td>
            <td align="right"><input id="commit" type="submit" value="提交"></td>
        </tr>
    </table>


</form>
</body>
</html>
