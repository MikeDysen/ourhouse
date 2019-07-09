$(function () {
    $("#dg").datagrid({
        toolbar:'#ToolBar',
        title:'街道信息',
        url:'getStreet',
        pagination: true,
        pageList: [4, 6, 7, 10, 12],/*//设置分页大小*/
        pageSize: 3,
        columns: [[
            {field: 'ck', checkbox: true, width: 100, align: 'left'},
            {field: 'id', title: '编号', width: 100},
            {field: 'name', title: '街道名称', width: 100},
            {field: 'district',title:'所在区域名称',
                formatter: function(value,row,index){
                    return row.district.name;
                }
            },
            {field:'delete',title:'删除',width:100,
                formatter:function (value,row,index) {
                    return '<a href="javascript:deleteStreet('+row.id+')">删除</a>';
                }}
        ]]
    });
});
function deleteStreet(id) {
    $.messager.confirm('提示信息','确定删除吗？',function (r) {
        if (r){
            $.post
        }
    })
}
function deleteStreet() {
    
}