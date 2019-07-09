$(function () {
    $("#dg").datagrid({
        title:'房屋类型信息',
        toolbar:"#ToolBar",
        url:'getType',
        pagination: true,
        pageList: [4, 6, 9, 12, 15],//设置分页大小
        pageSize: 3,//每页多少条
        columns: [[
            {field:'ck',checkbox:true,width:100},
            {field: 'id', title: '类型编号', width: 100},
            {field: 'name', title: '类型名称', width: 100},
            {field: 'do', title: '操作', width: 100,
                formatter:function (value,row,index) {
                    return '<a href="javascript:deleteHouseType('+row.id+')">删除</a>';
                }}
        ]]
    });
});
function Add() {// 点击添加按钮，弹出对话框
    $("#AddDialog").dialog("open").dialog("setTitle",">>>>>添加房屋类型");
}
function CloseDialog() {  /*关闭对话框*/
    $("#AddDialog").dialog("close");
}
function SaveDialog() {  /*实现添加业务 并提示*/
    $("#AddDialogForm").form("submit", {
        url: "addType",
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
function ModifyBySelect() {   /*提交修改前的准备工作*/
    var SelectRows = $("#dg").datagrid('getSelections');//得到一行的数据 ，数个数组
    if (SelectRows.length != 1) {
        $.messager.alert('提示框', '你还没有选中行，或者选择了多行', 'info');
        return;
    }
    //打开对话框
    $("#upDialog").dialog("open").dialog("setTitle", ">>>>修改区域");

    var row = SelectRows[0];//取出 数据中的对象
    $.post("getTypeById", {"id": row.id}, function (data) {
        $("#upDialogForm").form("load", data);
    }, "json");
}
function upSaveDialog() {
    $("#upDialogForm").form("submit", {
        url: "updateType",
        success: function (data) {
            data = $.parseJSON(data);
            if (data.result == 1) {
                //修改成功就关闭对话框  并刷新表格
                $("#upDialog").dialog("close");
                $("#dg").datagrid("reload");
            } else {
                $.messager.alert("提示框", "修改失败", "info");
            }
        }
    });
}
function deleteHouseType(obj) {
    $.messager.confirm('提示框','确定删除吗？',function (r) {
        if (r){
            $.post("deleteType",{"id":obj},function (data) {
                if (data.result==1){
                    $("#dg").datagrid("reload");
                }else {
                    $.messager.alert('提示框','删除失败','info');
                }
            },"json");
        }else {
            $.messager.alert('提示框','删除失败','info');
        }

    });
}
function DeleteBySelects() {
    var selectRows = $("#dg").datagrid("getSelections");

    //如果没有选中行的话，提示信息
    if (selectRows.length < 1) {
        $.messager.alert("提示消息", "请选择要删除的记录！", 'info');
        return;
    }
    //如果选中行了，则要进行判断
    $.messager.confirm("确认消息", "确定要删除所选记录吗？", function (isDelete) {

        //如果为真的话
        if (isDelete) {
            //定义变量值
            var strIds = "";
            //拼接字符串，这里也可以使用数组，作用一样
            for (var i = 0; i < selectRows.length; i++) {
                strIds += selectRows[i].id + ",";
            }
            // alert(strIds);
            //循环切割
            strIds = strIds.substr(0, strIds.length - 1);
            $.post('deleteTypes',{"id":strIds}, function (jsonObj) {
                if (jsonObj.result>0) {
                    $.messager.alert('提示', '删除成功！');
                    $("#dg").datagrid("reload"); //删除成功后 刷新页面
                } else {

                    $.messager.alert('提示信息', '删除失败，请联系管理员！', 'warning');
                }
            }, "JSON");
        }
    });

}
