<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Badge Signup Form template Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <!-- <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script> -->
    <!-- Custom Theme files -->
    <link href="css/register.css" rel="stylesheet" type="text/css" media="all" />
    <style type="text/css">
        .w3layouts-main{
            position: relative;
            width: 1900px;
            height: 1000px;

        }
        .w3layouts-main h1{
            position: absolute;
            top: 50px;
            left: 700px;

        }
        .agileits-top{
            position: absolute;
            top: 400px;
            left: 660px;
            width: 500px;

        }
        .copyright{
            position: absolute;
            bottom: 50px;
            left: 660px;
        }

    </style>
    <!-- //Custom Theme files -->
</head>

<body>
<!-- main -->
<div class="w3layouts-main">
    <h1 style="font-weight: 500;">Badge Signin Form</h1>
    <div class="agilesign-form">
        <div class="agileits-top">
            <form action="loginServlet" method="post">
                <div class="styled-input w3ls-text">
                    <input type="text" name="phone" required=""/>
                    <label style="color:black;font-weight: bolder; ">Phone</label>
                    <span></span>
                </div>
                <div class="styled-input w3ls-text">
                    <input type="password" name="password" required="">
                    <label style="color: black;font-weight: bolder;">Password</label>
                    <span></span>
                </div>
                <div class="wthree-text">
                    <p>
                        <input type="checkbox" id="brand" value="">
                        <label style="color: black;" for="brand"><span></span>I accept the terms of use</label>
                    </p>
                </div>
                <div class="agileits-bottom">
                    <input type="submit" value="Sign In">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- //main -->
<!-- copyright -->
<div class="copyright">
    <p>© 2017 Badge Signup Form . All rights reserved | Design by yjq<p>
</div>
<!-- //copyright -->
</body>
</html>
