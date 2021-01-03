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
<table class="table"  border="1" cellpadding="0" cellspacing="0" width="800px"  style="table-layout:fixed; background-color: #5F9EA0;filter: alpha(opacity=100);opacity: 0.9;">

    <tr style="height: 50px;text-align: center" class="firstRow">
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
            <tr class="nextRow" style="height:50px;text-align: center">
                <td><label>${U.demand_id}</label></td>
                <td><label>${U.u_name}</label></td>
                <td><label >${U.u_id}</label></td>
                <td style=" overflow: hidden; text-overflow:ellipsis;"><span>${U.dem_contentType}</span></td>
                <td style=" overflow: hidden; text-overflow:ellipsis;">${U.dem_content}</td>
                <td><label style="font-size: 17px">${U.dem_time}</label></td>
                <td><label>${U.price}</label></td>
                <td style="text-align: center"><a style="color: wheat;list-style: none;font-size: 20px; text-decoration: none;" href="AdmServlet?flag=5&demand_id=${U.demand_id}">删除</a></td>
            </tr>

        </c:if>

    </c:forEach>
</table>

</body>
</html>
