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
<table class="table"   border="1" cellpadding="0" cellspacing="0" width="800px"  style="table-layout:fixed; background-color: #5F9EA0;filter: alpha(opacity=100);opacity: 0.9;">
    <tr style="height: 50px" class="firstRow">
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

<table class="table1"   border="1" cellpadding="0" cellspacing="0"   style="table-layout:fixed; background-color: #5F9EA0;filter: alpha(opacity=100);opacity: 0.9;">
    <tr style="height: 50px">
        <th>接受者姓名</th>
        <th>完成时间</th>
        <th>是否已完成</th>
        <th>是否已支付</th>
        <th>是否已评价</th>
    </tr>

    <tr>
        <td>${findOrder.j_name}</td>
        <td>${findOrder.finished_time}</td>
        <td><c:if test="${findOrder.finished_time!=null}">已完成</c:if><%--判断是否完成--%>
            <c:if test="${findOrder.finished_time==null}">未完成</c:if>
        </td>
        <td><c:if test="${findOrder.finished_time==null||findOrder.isPay==0}">未支付</c:if>
            <c:if test="${findOrder.isPay!=0}">已支付</c:if>
        </td>
        <td><c:if test="${findOrder.isPay==0||findOrder.isEva==0}"> 未评价</c:if><%--isEva=0是未进行评价--%>
            <c:if test="${findOrder.isEva!=0}">已评论</c:if>
        </td>
    </tr>
</table>
<hr>
<div class="evaluateContent" style="background-color: wheat;filter: alpha(opacity=100);opacity: 0.9; border: 1px #FFFFFF;width: 500px" >

    <h2>已有评论</h2>

    <%--    如果订单已评论，则循坏打印出--%>
    <c:if test="${findOrder.isEva==1}">
        <c:forEach var="U" items="${orderAllEva}"  >

            <%--@elvariable id="findOrder" type="com.bean.Order"--%>
            <c:if test="${U.order_id==findOrder.order_id}">
                <span><b>${U.u_name}发表评论:</b></span><br>
                <span>${U.eva_content}</span>
                <span>—————${U.eva_time}</span>
            </c:if><%--判断是否已经有评论,--%>
            <hr>
        </c:forEach>
    </c:if>
    <c:if test="${findOrder.isEva==0}">
        <span><b>暂时还没有评论</b></span>
    </c:if>
    <div>
        <br><hr><br>

        <a style="font-size: larger;color:black" href="AdmServlet?flag=2">返回上一级</a>
    </div>
</div>

</body>
</html>
