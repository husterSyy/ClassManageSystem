<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Find User Info</title>
</head>
<body>
	<center><h1><font size="5">查询用户信息</font></h1>
	<form action="./FindController" method="post">
	<table border="0">
	<tr>
	<td>输入用户ID:</td>
	<td><input type="text" name="UserID" size="20"></td>
	<td><input type="submit" name="Submit" value="查询"></td>
	</table>
	</form>
	</center>
</body>
</html>