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
		<span class="text1">当前您已发布的需求列表</span>
	</div>
	<table class="table"  border="1" cellpadding="0" cellspacing="0" width="1080px" >
		<tr class="firstRow">
			<th>需求ID</th>
			<th>发布者姓名</th>
			<th>需求种类</th>
			<th>需求内容</th>
			<th>发布时间</th>
			<th>价格</th>
			<th>是否已接单</th>
<%--			<th>订单ID</th>--%>
			<th>操作</th>
		</tr>
		<c:forEach var="U" items="${personalAllDemand}"  >
			<form class="form" action="DemandUpdateServlet?demand_id=${U.demand_id}" method="post">
				<tr class="nextRow">
					<td><label>${U.demand_id}</label></td>
					<td><label>${U.u_name}</label></td>
					<td><input style="font-size: 20px; background-color: #5F9EA0;border-color: #000000;" type="text" value="${U.dem_contentType}" name="dem_contentType"></td>
					<td><input style="font-size: 20px; background-color: #5F9EA0;border-color: #000000;" type="text" value="${U.dem_content}" name="dem_content"></td>
					<td><label style="font-size: 17px">${U.dem_time}</label></td>
					<td><input style="font-size: 20px; background-color: #5F9EA0;border-color: #000000;" type="text" value="${U.price}" name="price"></td>
					<td><c:if test="${U.order_id!=0}"><span style="width: 50px" class="green">已接单</span></c:if><%--判断是否接单--%>
					    <c:if test="${U.order_id==0}"><span style="width: 50px" class="red">未接单</span></c:if>
					</td>

<%--					<td><label>${U.order_id}</label></td>--%>
<%--					只有未结单的需求或订单才能进行删除或修改   已接单的订单可以进行查看--%>
					<td><c:if test="${U.order_id==0}"><a class="a" href="DemandDeleteServlet?demand_id=${U.demand_id}">删除</a>
						<input class="submit" type="submit" value="更新"/>
					    </c:if>
						<c:if test="${U.order_id!=0}">
							<a class="a" style="color: #87CEEB" href="Visitor_showOrderServlet?flag=1&demand_id=${U.demand_id}">查看订单</a>
							</c:if>

					</td>
				</tr>
			</form>
		</c:forEach>
	</table>

</body>
</html>
