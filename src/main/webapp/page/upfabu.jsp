<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ZLZ
  Date: 2019/7/2
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<HEAD>
    <TITLE>青鸟租房 -发布房屋信息</TITLE>
    <META content="text/html; charset=utf-8" http-equiv=Content-Type>
    <LINK
            rel=stylesheet type=text/css href="../css/style.css">
    <META name=GENERATOR content="MSHTML 8.00.7601.17514">
    <script language="JavaScript" src="../admin/js/jquery-1.8.3.js"></script>
    <script language="JavaScript">
        $(function () {
            $.post("getType", null, function (data) {
                for (var i = 0; i < data.length; i++) {
                    var node = $("<option value=" + data[i].id + ">" + data[i].name + "</option>");
                    $("#typeId").append(node);
                }
                $("#typeId").val(${house.typeId});
            }, "json");
            $.post("getDistrict", null, function (data) {
                for (var i = 0; i < data.length; i++) {
                    var node = $("<option value=" + data[i].id + ">" + data[i].name + "</option>");
                    $("#district_id").append(node);
                }
                $("#district_id").val(${house.did});
                //加载街道
                loadStreet($("#district_id").val());
            }, "json");
            $("#district_id").change(function () {
                loadStreet($(this).val());  //重新加载街道
            });
        });

        function loadStreet(did) {
            $.post("getStreetByDistrictId", {"id": did}, function (data) {
                $("#street_id>option:gt(0)").remove();
                for (var i = 0; i < data.length; i++) {
                    //使用$()工厂函数创建标签
                    var node = $("<option value=" + data[i].id + ">" + data[i].name + "</option>");
                    //将创建的标签添加下拉列表
                    $("#street_id").append(node);
                }
                $("#street_id").val(${house.streetId});
            }, "json");
        }
    </script>
</HEAD>
<BODY>
<DIV id=header class=wrap>
    <DIV id=logo><IMG src="../images/logo.gif"></DIV>
</DIV>
<DIV id=regLogin class=wrap>
    <DIV class=dialog>
        <DL class=clearfix>
            <DT>新房屋信息发布</DT>
            <DD class=past>填写房屋信息</DD>
        </DL>
        <DIV class=box>
            <FORM id=add_action method=post name=ss
                  action=updateHouse enctype="multipart/form-data">
                <DIV class=infos>
                    <TABLE class=field>
                        <TBODY>
                        <TR>
                            <TD class=field>标　　题：</TD>
                            <input type="hidden" name="id" value="${house.id}">
                            <TD><INPUT id=add_action_title class=text type=text name=title value="${house.title}"></TD>
                        </TR>
                        <TR>
                            <TD class=field>户　　型：</TD>
                            <TD><SELECT class=text id="typeId" name=typeId>
                                <option value="">请选择</option>
                            </SELECT></TD>
                        </TR>
                        <TR>
                            <TD class=field>面　　积：</TD>
                            <TD><INPUT id=add_action_floorage class=text type=text
                                       name=floorage value="${house.floorage}"></TD>
                        </TR>
                        <TR>
                            <TD class=field>价　　格：</TD>
                            <TD><INPUT id=add_action_price class=text type=text name=price value="${house.price}"></TD>
                        </TR>
                        <TR>
                            <TD class=field>房产证日期：</TD>
                            <TD><INPUT class=text type=date name=pubdate
                                       value="<fmt:formatDate value="${house.pubdate}" pattern="yyyy-MM-dd"></fmt:formatDate>">
                            </TD>
                        </TR>
                        <TR>
                            <TD class=field>位　　置：</TD>
                            <TD>区：<SELECT class=text name=district_id id="district_id">
                                <option value="">请选择</option>

                            </SELECT> 街：<SELECT class=text name=streetId id="street_id">
                                <OPTION value="">请选择</OPTION>
                            </SELECT></TD>
                        </TR>

                        <TR>
                            <TD class=field>联系方式：</TD>
                            <TD><INPUT id=add_action_contact class=text type=text name=contact value="${house.contact}">
                            </TD>
                        </TR>
                        <TR>
                            <TD class=field>图片：</TD>
                            <TD><img src="http://localhost:80/${house.path}" width="100" height="100">
                                <INPUT id=ssss class=text type=file name=pfile>
                            </td>
                        </TR>
                        <TR>
                        <TR>
                            <TD class=field>详细信息：</TD>
                            <TD><TEXTAREA name=description>${house.description}</TEXTAREA></TD>
                        </TR>
                        </TBODY>
                    </TABLE>
                    <DIV class=buttons><INPUT value=立即更新 type=submit>
                    </DIV>
                </DIV>
            </FORM>
        </DIV>
    </DIV>
</DIV>
<DIV id=footer class=wrap>
    <DL>
        <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
        <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
    </DL>
</DIV>
</BODY>
</HTML>
