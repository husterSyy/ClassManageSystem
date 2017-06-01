<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>学生信息交互网站</h1>
	<%
	//获取session的登录状态
	String user=(String) session.getAttribute("user");
	 %>
	 <%
	 if(user==null||"".equals(user)){  //用户没有登录
	  %>
	  欢迎来到学生信息交互网站
	  <a href="${pageContext.request.contextPath }/../login.jsp">登录</a>
	  <a href="#">注册</a>
	  <%
	  }else{//用户登陆过
	  
	   %>
	   欢迎回来！<%=user %>!
	   <a href="${pageContext.request.contextPath }/servlet/LogoutServlet">注销</a>
	   
	   <%
	   }
	    %>
	   
	   
	   
	   
	   
	   
	   
</body>
</html>