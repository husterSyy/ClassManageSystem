<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.Announce" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Found User Info</title>
</head>
<body>
<jsp:useBean id="announce" scope="session"  type="model.Announce">
</jsp:useBean>
	<table border=3>
	<tr>
	
	</tr>
	<tr>
	<td>公告主题：</td>
	<td><jsp:getProperty name="announce" property="announceTitle"/></td>
	</tr>
	<tr>
	<td>公告内容：</td>
	<td><jsp:getProperty name="announce" property="details"/></td>
	</tr>
	
	</table>
</body>
</html>