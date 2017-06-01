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
	min-width:960px;
	background: #000;
	background: url(../images/bg_body.jpg) center 0 no-repeat #B0C2E6;
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
<div class="myloading">
		<div class="d">管理员登录</div>
	<div class="n_container">
	<form id="myform" action="LoginForAdmin" method="post">
	<label class="myname">
		 <span class="mylable">学号</span>
		<input type="text" name="studentID"> 
		<br class="clear"> 
	</label>
		<label class="myname"> 
	<span class="mylable">密码</span>
	<input type="password" name="password"> 
	<br class="clear"> 
		</label>
	<div style="margin-left: 70px;"></div >
	
	<label class="myname1"> 
		

  
  
		<input type="submit" value="登录" />
	</label>
	
</form>
	
	

	</div>
	
</div>


</body>
</html>
</html>