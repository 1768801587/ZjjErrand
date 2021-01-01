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
    <link rel="stylesheet" type="text/css" href="css/Errand_reception.css"/>
</head>

<body>
<div class="first" >
    <span class="text1">接 收 需 求</span>
</div>
<div class="second">
    <form class="demandForm" action="OrderAddServlet" method="post" onsubmit="return validate()">
        <label class="demandWords">需求种类:</label><br><br>
        <input type="text" readonly name="dem_contentType" class="demandText" value="${demand.dem_contentType}" /><br><br>

        <label class="demandWords">需求说明:</label><br><br>
        <input type="text" readonly name="dem_contentDescription" class="demandText" value="${demand.dem_content}" /><br><br>

        <label class="demandWords">发布者姓名:</label><br><br>
        <input type="text" readonly name="visitor_name" class="demandText" value="${demand.u_name}" /><br><br>

        <label class="demandWords">发布者ID:</label><br><br>
        <input type="text" readonly name="visitor_id" class="demandText" value="${demand.u_id}" /><br><br>

        <label class="demandWords">发布时间:</label><br><br>
        <input type="text" readonly name="dem_time" class="demandText" value="${demand.dem_time}" /><br><br>

        <label class="demandWords">价格:</label><br><br>
        <input type="text" readonly name="price" class="demandText" value="${demand.price}" /><br><br>

        <label class="demandWords">需求ID:</label><br><br>
        <input type="text" readonly name="demand_id" class="demandText" value="${demand.demand_id}" /><br><br>

        <label class="demandWords">接收时间:</label><br><br>
        <input type="text" readonly name="reception_time" class="demandText" value="${reception_time}" /><br><br>

        <input class="demandButton" type="submit" value="确认接单" />
    </form>
</div>
</body>
</html>
