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
        <td>${oneOrder.order_id}</td>
        <td>${oneOrder.demand_id}</td>
        <td>${oneOrder.f_name}</td>
        <td>${oneOrder.ord_contentType}</td>
        <td>${oneOrder.ord_content}</td>
        <td>${oneOrder.price}</td>
        <td>${oneOrder.dem_time}</td>
        <td>${oneOrder.ord_time}</td>
    </tr>
</table>

<table class="table1"  border="1" cellpadding="0" cellspacing="0">
    <tr>
        <th>接受者姓名</th>
        <th>完成时间</th>
        <th>是否已完成</th>
        <th>是否已支付</th>
    </tr>

    <tr>
        <td>${oneOrder.j_name}</td>
        <td>${oneOrder.finished_time}</td>
        <td><c:if test="${oneOrder.finished_time!=null}">已完成</c:if><%--判断是否完成--%>
            <c:if test="${oneOrder.finished_time==null}">未完成</c:if>
        </td>
        <td><c:if test="${oneOrder.isPay!=1}">未支付</c:if>
            <c:if test="${oneOrder.isPay==1}">已支付</c:if>
        </td>

    </tr>
</table>
<hr>
<div class="evaluateContent" style=" border-color: #FFFFFF;border:1px;width: 500px" >

    <span>评论：</span><br>

    <c:if test="${oneOrder.isEva==1}">
        <c:forEach var="U" items="${oneOrderAllEva}"  >

            <c:if test="${U.order_id==oneOrder.order_id}">
                <span><b>${U.u_name}发表评论:</b></span><br>
                <span>${U.eva_content}</span>
                <span>—————${U.eva_time}</span>
            </c:if><%--判断是否已经有评论,--%>

            <c:if test="${oneOrder.isEva==0}">
                <span><b>暂时还没有评论</b></span>
            </c:if>
            <br>
            <hr>

        </c:forEach>
    </c:if>


</div>
<div>
    <br><hr><br>

    <a style="font-size: larger;color:black" href="Errand_showOrdServlet?step=1">返回上一级</a>
</div>
</body>
</html>
