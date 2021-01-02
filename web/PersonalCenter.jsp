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
		<link rel="stylesheet" type="text/css" href="css/visitor_personal.css"/>
	</head>

	<body>
		<div class="first">
			<span class="text1">个 人 中 心</span>
		</div>
		<div class="second">
			<form class="demandForm" action="UpdatePerInfoServlet" method="post" onsubmit="return validate()">
				<label class="demandWords">姓 名:</label><br><br>
				<input type="text" name="u_name" class="demandText" value="${loginUser.u_name}" /><br><br><!--value 中的值可以根据后端中的代码 取出  如requestd的setAttribute方法   或  respone的setAttribute方法  或 session 或-->

				<label class="demandWords">性 别:</label><br><br>
				<input type="text" name="sex" class="demandText" value="${loginUser.sex}" /><br><br>

                <label class="demandWords">电话号码:</label><br><br>
                <input type="text" name="phone" class="demandText" value="${loginUser.phone}" /><br><br>
				
				<label class="demandWords">密 码:</label><br><br>
				<input type="text" name="pwd" class="demandText" value="${loginUser.pwd}" /><br><br>
				
				<label style="position: absolute;left: 70px;" class="demandWords">用户种类:</label>
				<label style="position: absolute;left: 185px;top: 380px; font-size: 25px;font-weight: 500;color: aqua">
					<c:if test="${loginUser.u_type==3}"><span style="width: 50px" class="green">管理员</span></c:if>
					<c:if test="${loginUser.u_type==2}"><span style="width: 50px" class="green">跑腿用户</span></c:if>
					<c:if test="${loginUser.u_type==1}"><span style="width: 50px" class="green">游客用户</span></c:if>
				</label><br> <br>
				<input class="demandButton" type="submit" value="修 改" />
			</form>
		</div>
	</body>
</html>
