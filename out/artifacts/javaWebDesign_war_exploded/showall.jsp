<%--
  Created by IntelliJ IDEA.
  User: shinelon
  Date: 2020/12/27
  Time: 8:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>所有用户页面</title>
</head>

<body>
<h1>所有用户列表</h1>
<table  width="400px" border="1" cellpadding="0" cellspacing="0" >
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>性别</th>
        <th>密码</th>
        <th>手机</th>
        <th>类型</th>
    </tr>
    <c:forEach var="U" items="${userAll}"  >
        <form action="<%--UpdateServlet--%>*" method="post">
            <tr>
                <td><input type="text" value="${U.u_id}" name="f_id" ></td>
                <td><input type="text" value="${U.u_name}" name="f_name"></td>
                <td><input type="text" value="${U.sex}" name="sex"></td>
                <td><input type="text" value="${U.pwd}" name="pwd"></td>
                <td><input type="text" value="${U.phone}" name="phone"></td>
                <td><input type="text" value="${U.u_type}" name="u_type"></td>
                <td><a href="<%--DeleteServlet--%>?f_id=${U.u_id}">删除</a>  <input type="submit" value="更新"/></td>
            </tr>
        </form>
    </c:forEach>
</table>
</body>
</html>
