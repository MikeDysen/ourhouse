$(function () {
    $("#dg").datagrid({
        title:'用户信息',
        url:'getUsers',
        toolbar:"#ToolBar",
        pagination: true,
        pageList: [4, 6, 9, 12, 15],//设置分页大小
        pageSize: 4,//每页多少条
        columns: [[
            {field:'ck',checkbox:true,width:100,align:'left'},
            {field: 'id', title: '用户编号', width: 100},
            {field: 'name', title: '用户姓名', width: 100},
            {field: 'telephone', title: '联系方式', width: 100},
            {field:'do',title:'操作',width:100,
                formatter:function (value,row,index) {
                    return '<a href="javascript:deleteUser('+row.id+')">删除</a>';
                }}
        ]]
    });
});
function deleteUser(id) {
    $.messager.confirm('提示信息','确定删除吗？',function (r) {
        if (r){
            $.post('deleteUser',{"id":id},function (data) {
                if (data.result==1){
                    $("#dg").datagrid("reload");
                }else {
                    $.messager.alert('提示框','删除失败');
                }
            },"json");
        }
    })
}
function search() {  //此为重点
    var s_name=$("#s_name").val();
    var s_tel=$("#s_tel").val();
    $("#dg").datagrid("load",{"name":s_name,"telephone":s_tel});

}
function Add() {  /*打开对话框*/
    $("#AddDialog").dialog("open").dialog("setTitle", ">>>>添加区域");
}

function CloseDialog() {  /*关闭对话框*/
    $("#AddDialog").dialog("close");
}

function SaveDialog() {  /*实现添加业务 并提示*/
    $("#AddDialogForm").form("submit", {
        url: "addDistrict",
        success: function (data) {
            data = $.parseJSON(data);
            if (data.result == 1) {
                $("#AddDialog").dialog("close");
                $.messager.alert("提示框", "添加成功", "info");
                $("#dg").datagrid("reload");
            } else {
                $.messager.alert("提示框", "添加失败", "info");
            }
        }
    });
}