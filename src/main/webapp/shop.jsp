<%--
  Created by IntelliJ IDEA.
  User: crabman
  Date: 2018/5/25
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/validate/annotation">
    <table>
        <tr>
            <td>产品编号</td>
            <td><input name="productId" id="proDuctId"></td>
        </tr>
        <tr>
            <td>用户编号</td>
            <td><input id="userId" name="userId"></td>
        </tr>
        <tr>
            <td>交易日期</td>
            <td><input name="date" id="date"></td>
        </tr>
        <tr>
            <td>价格</td>
            <td><input name="price" id="price"></td>
        </tr>
        <tr>
            <td>数量</td>
            <td><input name="quantity" id="quantity"></td>
        </tr>
        <tr>
            <td>交易金额</td>
            <td><input name="amount" id="amount"></td>
        </tr>
        <tr>
            <td>用户邮件</td>
            <td><input id="email" name="email"></td>
        </tr>
        <tr>
            <td>备注</td>
            <td><textarea name="note" id="note" cols="20" rows="5"></textarea> </td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="提交"></td>

        </tr>
    </table>
</form>
</body>
</html>
