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
        // $(document).ready(function() {
        //     //JSON参数和类RoleParams一一对应
        //     var data = {
        //         //角色查询参数
        //         rolename: 'crabman',
        //         note : '你',
        //         //分页参数
        //         pageParams : {
        //             start : 0,
        //             limit : 20
        //         }
        //     }
        //     //Jquery的post请求
        //     $.post({
        //         url : "/param/findRole",
        //         //此处需要告知传递参数类型为JSON，不能缺少
        //         contentType : "application/json",
        //         //将JSON转化为字符串传递
        //         data : JSON.stringify(data),
        //         //成功后的方法
        //         success : function(result) {
        //         }
        //     });
        // });
        <!--传递数组给控制器-->
        // $(document).ready(function () {
        //    //删除角色的数组
        //     var idList=[1,2,3]
        //     //jquery的post请求
        //    $.post({
        //        url:"/param/deleteRoles",
        //        data:JSON.stringify(idList),
        //        contentType:"application/json",
        //        success:function () {
        //
        //        }
        //    }) ;
        // });
        // $(document).ready(function () {
        //     //新增角色数组
        //     var roleList=[
        //         {rolename:'小白兔1',note:'是奶糖1'},
        //         {rolename:'小白兔2',note:'是奶糖2'},
        //         {rolename:'小白兔2',note:'是奶糖2'}
        //     ]
        //     //jquery的post请求
        // $.post({
        //     url:"/param/addRoles",
        //     data:JSON.stringify(roleList),
        //     contentType:"application/json",
        //     success:function (result) {
        //
        //     }
        // })
        //
        // })
        $(document).ready(function () {
            $("#submit").click(function () {
                var str=$("form").serialize();
                //提交表单
                $.post({
                    url:"/param/commonPojo2",
                    //将form数据序列化，传递给后台，然后将数据以roleNmae=信息&&note=xx传递
                    data:$("form").serialize(),
                    success:function (result) {
                    }
                })
            })
        })
    </script>
</head>
<body>
<form  id="form" action="/param/addRole3">
    <table>
        <tr>
            <td>角色名称</td>
            <td><input id="roleName" name="rolename" value=""></td>
        </tr>
        <td>备注</td>
        <td><input id="note" name="note"></td>
        </tr>
        <tr>
            <td></td>
            <td align="right"><input id="submit" value="提交" type="submit"></td>
        </tr>

        <tr>
    </table>


</form>
</body>
</html>
