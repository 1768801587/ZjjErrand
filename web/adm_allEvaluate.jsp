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
<table  border="1" cellpadding="0" cellspacing="0" width="800px" >
    <tr>
        <th>评论ID</th>
        <th>评论人</th>
        <th>需求ID</th>
        <th>评论时间</th>
        <th>订单ID</th>
        <th>是否删除</th>
    </tr>

            <tr>
                <td>${U.eva_id}</td>
                <td>${U.u_name}</td>
                <td>${U.demand_id}</td>
                <td>${U.eva_time}</td>
                <td>${U.order_id}</td>
                <td><a href="AdmServlet?flag=8&eva_id=${U.eva_id}">确认删除</a></td>
            </tr>
</table>
        <span><b>评论内容：</b></span><br>
        <span><b style="color:red">${U.eva_content}</b></span><br>
        <hr>

    </c:forEach>

</div>


</body>
</html>
