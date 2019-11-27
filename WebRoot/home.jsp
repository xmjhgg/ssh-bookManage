<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,pojo.User,pojo.Book"%><%@ taglib prefix="s" uri="/struts-tags" %>
<% 	User user=(User)request.getSession().getAttribute("user"); 
	List<Book> books=(List<Book>)request.getSession().getAttribute("books");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>图书管理系统</title>
	<style>
		span{
			position: absolute;
		}
		body{
			background:url("img/timg.jpg") no-repeat;
			background-size:100% 100%;
		}
		#title{
			font-size: 25px;
			position: absolute;
			left: 50px;
			top:20px;
			color: #EE9A49;
		}
		#txt{
			
			position: absolute;
			top:100px;
			left:50px;	
		}
	
		#bookaction{
			border:2px solid black;
			padding:5px;
			position: absolute;
			top:150px;
			left:50px;
		}
		#useraction{
			border:2px solid black;
			padding:5px;
			position: absolute;
			top:290px;
			left:50px;
		}
		#allbook{
			position: absolute;
			top:100px;
			left:400px;
		}
		table,td{
			border-collapse:collapse;
			border: 3px solid #EE9A49;
			width:450px;
			height:30px;
			vertical-align:middle;
		}
		
	</style>
  </head> 
  
  <body>
  	<span id="title">欢迎使用图书管理系统</span>
  	<span id="txt">系统提示：管理员${sessionScope.user.username}登录成功</span><br>
  	<span style="top:130px;left:50px">图书操作</span><br>
  	<div id="bookaction" >
  		<a href="Book_add.jsp">添加图书</a><br>
  		<a href="Book_update1.jsp">修改图书</a><br>
  		<a href="Book_find1.jsp">查询图书</a><br>
  		<a href="Book_delete.jsp">删除图书</a><br>
  	</div>  
  	<span style="top:270px;left:50px">管理员操作</span><br>
	<div id="useraction">
    	<a href="updateUser_info.jsp">更改个人信息</a><br>
    	<a href="updateUser_mima.jsp">更改密码</a><br>
    	<a href="exit">退出系统</a>
	</div>
	<div id="allbook" >
		<table border="1px">
			<thead>
				<tr>
					<td>书本id</td>
					<td>书名</td>
					<td>类别</td>
					<td>上架时间</td>
				</tr>
			</thead>
			<tbody>
				<s:iterator id="book" value="#session.books">
					<tr>
						<td><s:property value="#book.bid"/></td>
						<td><s:property value="#book.bname"/></td>
						<td><s:property value="#book.classify"/></td>
						<td><s:property value="#book.date"/></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
    
    
  </body>
</html>
