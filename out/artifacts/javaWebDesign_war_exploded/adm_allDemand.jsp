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
<%--    <link rel="stylesheet" type="text/css" href="css/AllDemand.css"/>--%>
</head>
<body>
<div class="first">
    <span class="text1"><h2>所有未接单需求列表</h2></span>
</div>
<table class="table"  border="1" cellpadding="0" cellspacing="0" width="700px"  style="table-layout:fixed" >
    <tr class="firstRow">
        <th>需求ID</th>
        <th>发布者姓名</th>
        <th>发布者ID</th>
        <th>需求种类</th>
        <th>需求内容</th>
        <th>发布时间</th>
        <th>价格</th>
        <th>操作</th>
    </tr>
    <c:forEach var="U" items="${list}"  >
        <c:if test="${U.order_id==0}"><%--判断是否接单，展示未接单--%>
            <tr class="nextRow">
                <td><label>${U.demand_id}</label></td>
                <td><label>${U.u_name}</label></td>
                <td><label >${U.u_id}</label></td>
                <td><span>${U.dem_contentType}</span></td>
                <td style=" overflow: hidden; text-overflow:ellipsis; white-space: nowrap;">${U.dem_content}</td>
                <td><label style="font-size: 17px">${U.dem_time}</label></td>
                <td><label>${U.price}</label></td>
                <td><a href="AdmServlet?flag=5&demand_id=${U.demand_id}">删除</a></td>
            </tr>

        </c:if>

    </c:forEach>
</table>

</body>
</html>
