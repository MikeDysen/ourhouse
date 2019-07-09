<%--
  Created by IntelliJ IDEA.
  User: ZLZ
  Date: 2019/6/29
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>
    <script type="application/javascript" src="js/users.js">

    </script>
</head>
<body>
<table id="dg"></table>
<div id="ToolBar">
    <div style="height: 40px;">
        <a href="javascript:addUser()" iconCls="icon-add" class="easyui-linkbutton" plain="true">添加</a>
        <a href="javascript:updateUser()" iconCls="icon-edit" class="easyui-linkbutton"plain="true">修改</a>
        <a href="javascript:deleteUsers()" iconCls="icon-remove" class="easyui-linkbutton"plain="true">批量删除</a>
    </div>
    <div >
        姓名：<input type="text" id="s_name" name="name">
        电话：<input type="text" id="s_tel" name="telephone">
        <a href="javascript:search()" class="easyui-linkbutton" iconCls="search" plain="true">搜索</a>
    </div>
</div>
<%--<div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons" style="width: 280px;"></div>--%>
</body>
</html>