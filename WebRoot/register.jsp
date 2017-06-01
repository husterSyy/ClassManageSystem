<%@ page language="java" import="java.util.*, java.sql.*,model.Student"  pageEncoding="utf-8"%>  
<%@ page import="model.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body {
	font: 13px/19px "微软雅黑", Arial, sans-serif;
	color:#666565;
	position:relative;
	
	background: #B0C2E6;
}
.myloading{
	margin-left:300px;
	margin-top:100px;
	width:600px;
	height:300px;
	border:10px solid red;
}
.d{
margin-top:100px;
	margin-left:-150px;
  text-align:center;
}

.myname{margin-left:400px;}
.i{margin-bottom:10px;}
.l{width:100px;}
</style>

</head>
<body>
<table border=1 align="center">
<div class="d"><h2>注册界面</h2></div>
</table>
 
<div class="d">
<form id="myform" action="Register" method="post">

<label class="l" for="studentID">输入学生号：</label>
<input class="i" type="text" name="studentID" size="10"><br>

<td>
<label for="password">输入密码：</label>
<input class="i" type="text" name="password" size="10"></td><br>

<label for="name">输入姓名：</label>
<input type="text" name="name"  size="10"><br>
<td><input type="submit" value="马上注册" name="Submit"></td><br>
</form>

</div>


</body>
</html>