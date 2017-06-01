
<!-- JSP页面：userLogin.jsp 负责登录界面的显示 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
<http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh">

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Find User Info</title>

<head>
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

</style>
</head>
<body class="">
<div class="myloading">
<div class="newsletter_title">班级成员登录</div>
<div class="n_container">
<form id="myform" action="LoginForStudent" method="post">
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
<div style="margin-left: 70px;">
</div >
<label class="myname"> 
<br class="clear">
<input type="submit" value="登录" />
</label>

</form>
<label class="myname">
<input type="button" value="注册" onclick="document.location='register.jsp';" />
</label></span></div>
<br class="clear">
<div class="clear"></div>
</div>

</body>
</html>


