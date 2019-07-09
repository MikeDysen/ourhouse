<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML>
<HEAD><TITLE>青鸟租房 - 首页</TITLE>
    <META content="text/html; charset=utf-8" http-equiv=Content-Type>
    <LINK rel=stylesheet type=text/css href="../css/style.css">
    <META name=GENERATOR content="MSHTML 8.00.7601.17514">
    <script language="JavaScript" src="js/jquery-1.8.3.js"></script>
    <script language="JavaScript">
        $(function () {
            //异步加载类型
            $.post("getType",null,function (data) {
                for (var i = 0; i <data.length ; i++) {
                    var node=("<option value="+data[i].id+">"+data[i].name+"</option>");
                    $("#typeid").append(node);
                }
                //设置选中项
                $("#typeid").val(${param.typeid});
            },"json");
            //异步加载区域
            $.post("getDistrict",null,function (data) {
                for (var i = 0; i <data.length ; i++) {
                    var node=("<option value="+data[i].id+">"+data[i].name+"</option>");
                    $("#district_id").append(node);
                }
                //设置选中项
                $("#district_id").val(${param.districtid});
                loadStreet( $("#district_id").val());
                //加载街道
                $("#district_id").change(function(){
                    loadStreet($(this).val());  //重新加载街道
                });
            },"json");
        });
        function loadStreet(did) {
            $.post("getStreetByDistrictId",{"id":did},function (data) {
                $("#street_id>option:gt(0)").remove();
                for(var i=0;i<data.length;i++){
                    //使用$()工厂函数创建标签
                    var node=$("<option value="+data[i].id+">"+data[i].name+"</option>");
                    //将创建的标签添加下拉列表
                    $("#street_id").append(node);
                }
                $("#street_id").val(${param.streetid});  //设置街道的选中项
            },"json")
        }
        function doPage(pageNum) {
            $("#savepage").val(pageNum);
            $("#sform").submit()
        }
    </script>
</HEAD>
<BODY>
<DIV id=header class=wrap>
    <DIV id=logo><IMG src="../images/logo.gif"></DIV>
</DIV>
<DIV id=navbar class=wrap>
        <FORM id=sform method="post" action=getHouseByP enctype="multipart/form-data">
            <input  name="page" id="savepage" type="hidden" value="1">
            <div>
                标题：<INPUT class=text type=text name=title value="${param.title}">
                区域:
                <select name="districtid" id="district_id">
                    <option selected value="">不限</option>
                </select>
                街道:
                <SELECT id=street_id name=streetid>
                    <OPTION selected value="">不限</OPTION>
                </SELECT>
                房型:
                <SELECT name=typeid id="typeid">
                    <OPTION selected value="">不限</OPTION>
                </SELECT>
                价格:<input type="text" name="min_price" value="${param.min_price}">到
                <input type="text" name="max_price" value="${param.max_price}">
                <input type="submit" id="search" name="search" value=搜索 >
            </div>
        </FORM>
</DIV>
<DIV class="main wrap">
    <TABLE class=house-list>
        <TBODY>
        <c:forEach items="${info.list}" var="h">
            <TR>
                <TD class=house-thumb>
                    <span>
                        <A href="details.htm" target="_blank">
                            <img src="http://localhost:80/${h.path}" width="100" height="75" alt="">
                        </a>
                    </span>
                </TD>
                <TD>
                    <DL>
                        <DT><A href="details.htm" target="_blank">${h.title}</A></DT>
                        <DD>${h.dname}->>${h.sname}->>${h.floorage}平米<BR>联系方式：${h.contact}</DD>
                    </DL>
                </TD>
                <TD class=house-type>${h.tname}</TD>
                <TD class=house-price><SPAN>${h.price}</SPAN>元/月</TD>
            </TR>
        </c:forEach>
        </TBODY>
    </TABLE>
    <DIV class=pager>
        <UL>
            <LI class=current><A href="javascript:doPage(1)">首页</A></LI>
            <LI><A href="javascript:doPage(${info.prePage==0?1:info.prePage})">上一页</A></LI>
            <LI><A href="javascript:doPage(${info.nextPage==0?info.pages:info.nextPage})">下一页</A></LI>
            <LI><A href="javascript:doPage(${info.pages})">末页</A></LI>
        </UL>
        <SPAN
                class=total>${info.pageNum}/${info.pages}页</SPAN></DIV>
</DIV>
<DIV id=footer class=wrap>
    <DL>
        <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
        <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
    </DL>
</DIV>
</BODY>
</HTML>
