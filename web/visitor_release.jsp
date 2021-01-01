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
		<link rel="stylesheet" type="text/css" href="css/visitor_release.css"/>
	</head>

	<body>
		<div class="first">
			<span class="text1">发 布 需 求</span>
		</div>
		<div class="second">
			<form class="demandForm" action="DemandReleaseServlet" method="post" onsubmit="return validate()">
				<label class="demandWords">需求种类:(长度为2)</label><br><br>
				<input type="text" name="dem_contentType" class="demandText" value="*" /><br><br>

				<label class="demandWords">需求说明:</label><br><br>
				<input type="text" name="dem_contentDescription" class="demandText" value="contentDescription" /><br><br>

				<label class="demandWords">价 格:</label><br><br>
				<input type="text" name="price" class="demandText" value="" /><br><br>

				<input class="demandButton" type="submit" value="发布" />
			</form>
		</div>
	</body>
</html>
