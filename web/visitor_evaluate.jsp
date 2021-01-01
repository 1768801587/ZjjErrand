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
    <%--    <link rel="stylesheet" type="text/css" href="css/visitor_showDemand.css"/>--%>
</head>
<body>
<table class="table"  border="1" cellpadding="0" cellspacing="0" >
    <tr class="firstRow">
        <th>订单ID</th>
        <th>需求ID</th>
        <th>发布者姓名</th>
        <th>订单种类</th>
        <th>订单内容</th>
        <th>价格</th>
        <th>发布时间</th>
        <th>接单时间</th>
    </tr>
    <tr class="secondRow">
        <td>${findOrder.order_id}</td>
        <td>${findOrder.demand_id}</td>
        <td>${findOrder.f_name}</td>
        <td>${findOrder.ord_contentType}</td>
        <td>${findOrder.ord_content}</td>
        <td>${findOrder.price}</td>
        <td>${findOrder.dem_time}</td>
        <td>${findOrder.ord_time}</td>
    </tr>
</table>

<table class="table1"  border="1" cellpadding="0" cellspacing="0">
    <tr>
        <th>接受者姓名</th>
        <th>完成时间</th>
        <th>是否完成</th>

    </tr>

    <tr>
        <td>${findOrder.j_name}</td>
        <td>${findOrder.finished_time}</td>
        <td><c:if test="${findOrder.finished_time!=null}">已完成</c:if><%--判断是否完成--%>
            <c:if test="${findOrder.finished_time==null}">未完成</c:if>
        </td>

    </tr>
</table>
<hr>
<div class="evaluateContent" style=" border-color: #FFFFFF;border:1px;width: 300px" >
    <h3>评论</h3>
    <form action="Visitor_EvaluateServlet?step=2" method="post">

        <label>内容:</label><textarea name="eva_content" rows="3"></textarea>
        <hr>
        <input type="submit" value="提交"/>
    </form>


</div>
<div>
    <a style="font-size: larger;color:black" href="Visitor_showOrderServlet?demand_id=${finder.demand_id}">返回上一级</a>
</div>
</body>
</html>
