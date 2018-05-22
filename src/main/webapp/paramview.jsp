<%--
  Created by IntelliJ IDEA.
  User: crabman
  Date: 2018/5/22
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.2.0.js"></script>
    <!--此处插入js脚本-->
    <script type="text/javascript">
        $(document).ready(function() {
            //JSON参数和类RoleParams一一对应
            var data = {
                //角色查询参数
                rolename : 'crabman',
                note : '你',
                //分页参数
                pageParams : {
                    start : 0,
                    limit : 20
                }
            }
            //Jquery的post请求
            $.post({
                url : "/param/findRole",
                //此处需要告知传递参数类型为JSON，不能缺少
                contentType : "application/json",
                //将JSON转化为字符串传递
                data : JSON.stringify(data),
                //成功后的方法
                success : function(result) {
                }
            });
        });
    </script>
</head>
<body>

<form action="/param/findRole" id="form">
    <table>
        <tr>
            <td>角色名称</td>
            <td><input id="roleName" name="role_name" value=""></td>
        </tr>
        <tr>
            <td>备注</td>
            <td><input id="note" name="note"></td>
        </tr>
        <tr>
            <td></td>
            <td align="right"><input type="submit" value="提交"></td>
        </tr>

    </table>


</form>
</body>
</html>
