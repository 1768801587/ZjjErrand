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
    <th>是否支付</th>
    <th>是否评价</th>
    </tr>

    <tr>
        <td>${findOrder.j_name}</td>
        <td>${findOrder.finished_time}</td>
        <td><c:if test="${findOrder.finished_time!=null}">已完成</c:if><%--判断是否完成--%>
            <c:if test="${findOrder.finished_time==null}">未完成</c:if>
        </td>
        <td><c:if test="${findOrder.finished_time==null}">未完成不能进行支付</c:if>
            <c:if test="${findOrder.finished_time!=null&&findOrder.isPay==0}"> <a class="a" href="Visitor_payServlet?findOrder_id=${findOrder.order_id}">点击进行支付</a></c:if><%--判断是否进行支付,isPay=0是 未支付--%>
            <c:if test="${findOrder.isPay!=0}">已支付</c:if>
        </td>
        <td><c:if test="${findOrder.isPay==0}"> 未支付不能评价</c:if><%--已经支付才能进行评价   isEva=0是未进行评价--%>
            <c:if test="${findOrder.isPay!=0&&findOrder.isEva==0}"><a class="a" href="Visitor_EvaluateServlet?step=1&order_id=${findOrder.order_id}">点击进行评价</a></c:if>
            <c:if test="${findOrder.isEva!=0}"><a class="a" href="Visitor_EvaluateServlet?step=1&order_id=${findOrder.order_id}">点击追加评价</a></c:if>
        </td>
    </tr>
</table>
<hr>
<div class="evaluateContent" style=" border-color: #FFFFFF;border:1px;width: 500px" >

<span>已有评论</span><br>

<%--    如果订单已评论，则循坏打印出--%>

<c:if test="${findOrder.isEva==1}">
    <c:forEach var="U" items="${orderAllEva}"  >

        <%--@elvariable id="findOrder" type="com.bean.Order"--%>
        <c:if test="${U.order_id==findOrder.order_id}">
            <span><b>${U.u_name}发表评论:</b></span><br>
            <span>${U.eva_content}</span>
            <span>—————${U.eva_time}</span>
        </c:if><%--判断是否已经有评论,--%>

        <c:if test="${findOrder.isEva==0}">
            <span><b>暂时还没有评论</b></span>
        </c:if>
        <br>
        <hr>

    </c:forEach>
</c:if>




</div>
<div>
    <br><hr><br>

    <a style="font-size: larger;color:wheat" href="visitor_showDemand.jsp">返回上一级</a>
</div>
</body>
</html>
