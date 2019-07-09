<%--
  Created by IntelliJ IDEA.
  User: ZLZ
  Date: 2019/6/29
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>
    <script type="application/javascript" src="js/street.js">


    </script>
</head>
<body>
<table id="dg"></table>
<div id="ToolBar">  <!--定义工具栏  设置id-->
    <div style="height: 40px;">
        <a href="javascript:Add()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a>
        <a href="javascript:ModifyBySelect()" class="easyui-linkbutton"
           iconCls="icon-edit" plain="true">修改</a>
        <a href="javascript:DeleteSingle()" class="easyui-linkbutton"
           iconCls="icon-remove" plain="true">单条删除</a>
        <a href="javascript:DeleteStreets()" class="easyui-linkbutton"
           iconCls="icon-remove" plain="true">批量删除</a>

    </div>
</div>
</body>
</html>