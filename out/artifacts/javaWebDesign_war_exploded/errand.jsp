<%--
  Created by IntelliJ IDEA.
  User: shinelon
  Date: 2020/12/26
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
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
    <link rel="stylesheet" type="text/css" href="css/visitor.css">
</head>

<body>
<div class="visitor" style="width:630px;float:left;height:500px;">
    <div class="top">
        <span class="zjj">张 家 界 跑 腿 平 台</span>
        <span class="zjj1">(跑腿)</span>
        <div class="firstA">
            <a href="#" onclick="document.getElementById('cont0').style.display='block',
						document.getElementById('cont1').style.display='none',document.getElementById('cont2').style.display='none',
						document.getElementById('cont3').style.display='none';">
                <label>接 收 需 求</label> </a>
        </div>
        <div class="secondA">
            <a href="Errand_showOrdServlet?step=1"  target="Errand_showOrder" onclick="document.getElementById('cont1').style.display='block',
						document.getElementById('cont0').style.display='none',document.getElementById('cont2').style.display='none',
						document.getElementById('cont3').style.display='none'">
                <label>查 看 订 单</label> </a>
        </div>
        <div class="thridA">
            <a href="#" onclick="document.getElementById('cont2').style.display='block',
					    document.getElementById('cont0').style.display='none',document.getElementById('cont1').style.display='none',
						document.getElementById('cont3').style.display='none'">
                <label>个 人 中 心</label> </a>
        </div>
        <div class="thridB" style="position: absolute;top: 20px;right: 20px">
            <a href="QuitServlet"><label style="font-size: 12px">退出登录</label></a>
        </div>
        <div class="fourthA">
            <a href="AllDemand2Servlet" target="allDemand" onclick="document.getElementById('cont3').style.display='block',
					    document.getElementById('cont0').style.display='none',document.getElementById('cont1').style.display='none',
						document.getElementById('cont2').style.display='none'">
                <label>所 有 订 单</label> </a>

        </div>

    </div>

    <div class="jm">
        <div id="cont0" style="display:none">
            　 <iframe src="Errand_reception.jsp" width="1200px" height="720"></iframe>
        </div>
        <div id="cont1" style="display:none">
            　 <iframe  name="Errand_showOrder" width="1200px" height="680"></iframe>
        </div>
        <div id="cont2" style="display:block">

            　 <iframe src="PersonalCenter.jsp" width="1200px" height="680"></iframe>
        </div>
        <div id="cont3" style="display:none">
            　 <iframe name="allDemand" width="1200px" height="680"></iframe>
        </div>

    </div>
</div>
</body>
</html>