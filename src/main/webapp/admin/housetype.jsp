<%--
  Created by IntelliJ IDEA.
  User: ZLZ
  Date: 2019/6/29
  Time: 8:51
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
    <script type="application/javascript" src="js/housetype.js">

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
        <a href="javascript:DeleteBySelects()" class="easyui-linkbutton"
           iconCls="icon-remove" plain="true">批量删除</a>
    </div>
</div>
<div id="AddDialog" class="easyui-dialog"
     buttons="#AddDialogButtons" style="width: 280px;height: 280px;padding: 10px" closed="true">
    <form id="AddDialogForm" method="post">
        <table>
            <tr>
                <td>戶型：</td>
                <td><input type="text" class="easyui-validatebox" required name="name" id="bname"></td>
            </tr>
        </table>
    </form>
</div>
<div id="AddDialogButtons">
    <a href="javascript:SaveDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a>
    <a href="javascript:CloseDialog()"
       class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
<div id="upDialog" class="easyui-dialog" buttons="#upDialogButtons"
     style="width: 250px;height: 250px;padding: 10px" closed="true">
    <form id="upDialogForm" method="post">
        <table>
            <tr>
                <td>類型编号</td>
                <td><input type="text" required name="id" readonly style="border: none" class="easyui-validatebox">
                </td>
            </tr>
            <tr>
                <td>類型名称</td>
                <td><input type="text" required name="name" class="easyui-validatebox"></td>
            </tr>
        </table>
    </form>
</div>
<div id="upDialogButtons">
    <a href="javascript:upSaveDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">更新</a>
    <a href="javascript:CloseDialog()"
       class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
</body>
</html>
