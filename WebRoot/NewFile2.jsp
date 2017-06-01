<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="utf-8"%>
    <%@page import="model.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include flush="true" page="NewFile1.jsp">
<jsp:param name="str" value="announceID"/>
</jsp:include>
<jsp:useBean id="aStudent" class="model.Student"  scope="page">
</jsp:useBean>
<%aStudent.setStudentID("12"); %>
<%=aStudent.getStudentID() %>
</body>
</html>