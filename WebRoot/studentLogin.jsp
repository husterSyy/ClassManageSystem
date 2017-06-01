<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班级活动管理系统</title>
<link href="style/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
body {
	font: 13px/19px "微软雅黑", Arial, sans-serif;
	color:#666565;
	position:relative;
	
	background: #B0C2E6;
}
.d{
	font-size:20px;
	margin-top:50px;
	margin-left:350px;
	margin-bottom:100px;
}
.myname{
margin-left:300px;
margin-bottom:10px;
}
.myname1{
margin-left:330px;
	margin-top:60px;
	
}
</style>
</head>
<body>
<body class="">
<div class="d1">
		<div class="d"><b>班级成员登录</b></div>
	<div class="n_container">
	<form id="myform" action="LoginForStudent" method="post">
	<label class="myname">
		<label class="mylable">学号</label>
		<input type="text" name="studentID"> <br>
	
	</label>
		<label class="myname"> 
	<span class="mylable">密码</span>
	<input type="password" name="password"> 
	
		</label>
	<div style="margin-left: 70px;"></div >
	
	<label class="myname1"> 
  
		<input type="submit" value="登录" />
	</label>
	
</form>
	
	<label class="myname1">
		<input type="button" value="注册" onclick="document.location='register.jsp';" />
		
	</label>

	</div>
	
</div>


</body>
</html>