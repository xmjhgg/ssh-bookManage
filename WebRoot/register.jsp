<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册</title>
    <style>
    	body{
			background:url("img/timg.jpg") no-repeat;
			background-size:100% 100%;
			text-align:center;
		}
		#register{
			position: relative;
			top:100px;
			font-size: 20px;
		}
		.errorMessage{
			font-size:15px;
			padding: 0px;0
			list-style-type: none;
		}
    </style>
  </head>
  
  <body>
  	<div id="register">
  		<form action="Register" method="post">
    	<s:fielderror name="register"/><br>
    	请输入用户名：<input name="username" type="text"><br>	&nbsp;&nbsp;
    	请输入密码：<input name="password" type="text"><br>		&nbsp;&nbsp;
    	请确认密码：<input name="password2" type="text"><br>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	姓名：<input name="name" type="text"><br>				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	联系电话：<input name="phone" type="text"><br>			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<input type="submit" value="注册">
    </form>
  	</div>
    	
  </body>
</html>
