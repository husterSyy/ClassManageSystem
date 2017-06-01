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
	position:relative;
	min-width:960px;
	background: #B0C2E6;

}
a:link{text-decoration:none;}
.title{
    font-weight:bold;
    font-size:20px;
    color:#e7ecf6;
    margin-left:400px;
    margin-top:80px;
}
.n_container{
   margin-left:380px;
   margin-top:150px;
   width:240px;
   height:150px;
   border:8px solid #394a55;
   background:gray;
}
 .register{
 padding-left:80px;
 margin-top:10px;
 
}
.sign{color:#e1e1e0;}
.type {
	color:#e1e1e0;
	margin-left:20px;
	margin-bottom:20px;
}
.myname{
	
	
}
.s1{
font-size:20px;

width:100px;

	margin-left:20px;
	margin-top:100px;
	margin-right:40px;
}
.s2{
font-size:20px;

width:100px;

	margin-right:20px;
}
</style>
</head>
<body>
<div class="body">

	<div class="title"><b>班级信息交互网站</b></div>
	<div class="n_container">
	<div class="sign">SIGN IN</div>
	<div class="type">请选择用户类型</div>
	
	<div class="myname">
		 <span class="s1"><a href="adminLogin.jsp">管理员</a></span>
		
	<span class="s2"><a href="studentLogin.jsp">学生</a></span>
	

		</div>
	
	
	
	<div class="register">
		<input type="button" value="注册" onclick="document.location='register.jsp';" />
		
	</div>

	</div>
	
</div>


</body>
</html>