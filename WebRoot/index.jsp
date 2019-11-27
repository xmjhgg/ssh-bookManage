<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>图书管理系统</title>
	<style>
		body{
			background:url("img/timg.jpg") no-repeat;
			background-size:100% 100%;
			text-align:center;
		}
		#login{
			position: relative;
			top:100px;
			font-size: 22px;
		}
		.errorMessage{
			font-size:18px;
			padding: 0px;
			list-style-type: none;
		}
	</style>
  </head>
  
  <body>
  	<div id="login">
  		欢迎使用本系统！
  		${requestScope.login}<br>
  		<s:fielderror name="login"/><br>
		<form action="Login">
		用户名:<input name="username" type="text"><br>
		密&nbsp;&nbsp;&nbsp;码:<input name="password" type="password"><br>
		<input type="submit" value="登录">
	</form>
	<a href="register.jsp">新用户注册</a>
  	
  	</div>
  	
  </body>
</html>
