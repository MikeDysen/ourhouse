
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>
    <script type="application/javascript" src="js/district.js"></script>
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

<!--添加 区域 对话框的具体内容-->
<div id="AddDialog" class="easyui-dialog"
     buttons="#AddDialogButtons" style="width: 280px;height: 280px;padding: 10px" closed="true">
    <form id="AddDialogForm" method="post">
        <table>
            <tr>
                <td>区域名称：</td>
                <td><input type="text" class="easyui-validatebox" required name="name" id="bname"></td>
            </tr>
        </table>
    </form>
    <a href="javascript:SaveDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a>
    <a href="javascript:CloseDialog()"
       class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
<!--定义添加对话框中的按钮-->
<div id="AddDialogButtons">

</div>
<!--修改 区域 对话框的具体内容-->
<div id="upDialog" class="easyui-dialog" buttons="#upDialogButtons"
     style="width: 250px;height: 250px;padding: 10px" closed="true">
    <form id="upDialogForm" method="post">
        <table>
            <tr>
                <td>区域编号</td>
                <td><input type="text" required name="id" readonly style="border: none" class="easyui-validatebox">
                </td>
            </tr>
            <tr>
                <td>区域名称</td>
                <td><input type="text" required name="name" class="easyui-validatebox"></td>
            </tr>
        </table>
    </form>

    <a href="javascript:upSaveDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">更新</a>
    <a href="javascript:CloseDialog()"
       class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
<!--定义修改区域对话框中的按钮-->
<div id="upDialogButtons">

</div>
<%--定義在區域中顯示街道的窗口--%>
<div id="showStreetDialog" class="easyui-dialog" buttons="#upDialogButtons"
     style="width: 600px; height: 500px; padding: 10px 20px;" closed="true">
    <table id="streetdg"></table>
    <div id="ToolBar1">  <!--定义工具栏  设置id-->
        <div style="height: 40px;">
            <a href="javascript:AddStreet()" class="easyui-linkbutton"
               iconCls="icon-add" plain="true">添加</a>
            <a href="javascript:UpdateStreet()" class="easyui-linkbutton"
               iconCls="icon-edit" plain="true">修改</a>
            <a href="javascript:DeleteStreets()" class="easyui-linkbutton"
               iconCls="icon-remove" plain="true">批量删除</a>
        </div>
    </div>
</div>

<%--定义添加街道对话框中的内容--%>
<div id="AddStreetDialog" class="easyui-dialog"
     buttons="#AddDialogButtons" style="width: 280px;height: 280px;padding: 10px" closed="true">
    <form id="AddStreetDialogForm" method="post">
        <table>
            <tr>
                <td>街道名称：</td>
                <td><input type="text" class="easyui-validatebox" required name="name" id="bname"></td>
            </tr>
            <tr>
                <td>所在区域编号：</td>
                <td><input type="text" required name="id" readonly style="border: none" class="easyui-validatebox"></td>
            </tr>
        </table>
    </form>
    <a href="javascript:SaveAddStreetDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a>
    <a href="javascript:CloseDialog()"
       class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
<div id="UpdateStreetDialog" class="easyui-dialog" buttons="#upDialogButtons"
     style="width: 250px;height: 250px;padding: 10px" closed="true">
    <form id="UpdateStreetForm" method="post">
        <table>
            <tr>
                <td>街道编号</td>
                <td><input type="text" required name="id" readonly style="border: none" class="easyui-validatebox">
                </td>
            </tr>
            <tr>
                <td>街道名称</td>
                <td><input type="text" required name="name" class="easyui-validatebox"></td>
            </tr>
        </table>
    </form>
    <a href="javascript:SaveUpdateStreetDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a>
    <a href="javascript:CloseDialog()"
       class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
</body>
</html>