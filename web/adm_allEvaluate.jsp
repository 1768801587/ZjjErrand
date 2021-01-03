<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<body>
<div class="first">
    <span class="text1"><h2>当前所有评论列表</h2></span>
    <c:forEach var="U" items="${evaluateList}"  >
<table  class="table"  border="1" cellpadding="0" cellspacing="0" width="800px"  style="table-layout:fixed; background-color: #5F9EA0;filter: alpha(opacity=100);opacity: 0.9;">
    <tr style="height: 50px;">
        <th>评论ID</th>
        <th>评论人</th>
        <th>需求ID</th>
        <th>评论时间</th>
        <th>订单ID</th>
        <th>是否删除</th>
    </tr>

            <tr style="height: 50px;text-align: center;">
                <td>${U.eva_id}</td>
                <td>${U.u_name}</td>
                <td>${U.demand_id}</td>
                <td>${U.eva_time}</td>
                <td>${U.order_id}</td>
                <td><a style="color: wheat;list-style: none;font-size: 20px; text-decoration: none;" href="AdmServlet?flag=8&eva_id=${U.eva_id}">确认删除</a></td>
            </tr>
</table>

        <div style="background-color: #5F9EA0">
            <span><b>评论内容：</b></span><br>
            <b style="color:#0A7369">${U.eva_content}</b>
        </div>
        <hr>

    </c:forEach>

</div>


</body>
</html>
