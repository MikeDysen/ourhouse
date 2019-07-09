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
    <script type="application/javascript">
        $(function () {
            $("#dg").datagrid({
                title: '已审核房屋信息',
                toolbar:"#ToolBar",
                url: 'getHousePassed',
                pagination: true,
                pageList: [4, 6, 9, 12, 15],//设置分页大小
                pageSize: 3,//每页多少条
                columns: [[
                    {field: 'id', title: '房屋编号', width: 100},
                    {field: 'tname', title: '户型', width: 100},
                    {field: 'price', title: '租金', width: 100},
                    {field: 'floorage', title: '房屋面积', width: 100},
                    {field: 'contact', title: '房主电话', width: 100},
                    {field: 'dname', title: '所在区域', width: 100},
                    {field: 'sname', title: '街道', width: 100},
                    {field: 'ispass', title: '是否审核', width: 100,
                        formatter:function (value,row,index) {
                            return "已审核"
                        }},
                    {field:'doPass',title:'是否审核',width:100,
                    formatter:function (value,row,index) {
                        return '<a href="javascript:doPass('+row.id+')" class="easyui-linkbutton" iconCls="icon-ok">撤销审核</a>'
                    }}
                ]]
            });
        });
function doPass(id) {
    $.post("NoPass",{"id":id},function (data) {
        if (data.result>0){
            $("#dg").datagrid("reload");
        }else {
            $.messager.alert('提示框','撤销审核失败！')
        }
    },"json");
}
function search() {
    
}
    </script>
</head>
<body>
<table id="dg"></table>
<div id="ToolBar">
    <div style="height: 40px;">
        <a href="javascript:doPassMore()" class="easyui-linkbutton"
           iconCls="icon-remove" plain="true">批量审核</a>
    </div>
    <div>
        户型: <input type="text" id="tname" name="tname" width="5px">
        租金: <input type="text" id="min_price" name="min_price"width="5px">到
        <input type="text" id="max_price" name="max_price"width="5px">
        所在区域: <input type="text" id="dname" name="dname"width="5px">
        <a href="javascript:search()" class="easyui-linkbutton" iconCls="search" plain="true">搜索</a>
    </div>
</div>
</body>
</html>