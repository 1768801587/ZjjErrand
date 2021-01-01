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
    <link rel="stylesheet" type="text/css" href="css/visitor_showDemand.css"/>
</head>
<body>
<div class="first">
    <span class="text1">当前您已接收的需求列表</span>
</div>
<table class="table"  border="1" cellpadding="0" cellspacing="0" width="1080px" >
    <tr class="firstRow">
        <th>订单ID</th>
        <th>发布者姓名</th>
        <th>接收者姓名</th>
        <th>订单内容</th>
        <th>订单种类</th>
        <th>发布时间</th>
        <th>接单时间</th>
        <th>价格</th>
        <th>是否完成</th>
        <th>操作</th>
        <th>查看</th>
    </tr>
    <c:forEach var="U" items="${personalAllOrder}"  >
        <form class="form" action="OrderFinServlet?order_id=${U.order_id}" method="post">
            <tr class="nextRow">
                <td>${U.order_id}</td>
                <td>${U.f_name}</td>
                <td>${U.j_name}</td>
                <td>${U.ord_content}</td>
                <td>${U.ord_contentType}</td>
                <td>${U.dem_time}</td>
                <td>${U.ord_time}</td>
                <td>${U.price}</td>
                <td><c:if test="${U.finished_time!=null}"><span style="width: 50px" class="green">已完成</span></c:if><%--判断是否完成--%>
                    <c:if test="${U.finished_time==null}"><span style="width: 50px" class="red">未完成</span></c:if>
                </td>
                    <%--只有未完成订单才能进行完成操作--%>
                <td><c:if test="${U.finished_time==null}">
                    <input class="submit" type="submit" value="完成"/>
                </c:if>
                </td>
                <td>
                    <a style="color: #87CEEB; font-size: 20px;" href="Errand_showOrdServlet?step=2&order_id=${U.order_id}">查看订单</a>
                </td>
            </tr>
        </form>
    </c:forEach>
</table>

</body>
</html>
