<%@ page language="java" import="java.util.*, java.sql.*" pageEncoding="gb2312"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告查询界面（主题）</title>
<style>
body {
	font: 13px/19px "微软雅黑", Arial, sans-serif;
	color:#666565;
	position:relative;
	min-width:960px;
	background: #000;
	background: url(../images/bg_body.jpg) center 0 no-repeat #B0C2E6;
}
a:link{color:blue;text-decoration:none;}
</style>
</head>
<body>
 
<form method="post" action="UpdateAnnounce" >
<label for="announceID">输入公告id：</label>
<input type="text" name="announceID" ><br>
<label for="announceTitle">输入公告主题：</label>
<input type="text" name="announceTitle" ><br>
<label for="details">输入公告内容：</label>
<input type="text" name="details" ><br>



<input type="submit" name="Submit" value="发布">
<a  href="http://localhost:8080/ClassManageSystem/mainPageAdmin.jsp">返回</a>
</form>
</body>
</html>