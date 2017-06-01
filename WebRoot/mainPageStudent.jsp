<%@ page language="java" import="java.util.*, java.sql.*,model.Student"  pageEncoding="utf-8"%>  
<%@ page import="model.Student" %>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<%request.setCharacterEncoding("UTF-8");%>   
<%response.setCharacterEncoding("UTF-8");%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">  
<html xmlns="http://www.w3.org/1999/xhtml">  

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<title>学生主界面</title>
<style>
body {
	font: 13px/19px "微软雅黑", Arial, sans-serif;
	color:#666565;
	position:relative;
	min-width:960px;
	background: #000;
	background: url(../images/bg_body.jpg) center 0 no-repeat #B0C2E6;
}
a:link{text-decoration:none;}
.s{
		font-size:20px;
		color:blue;
}
table{ width:1000px; margin:auto; padding: 5px; font-size:12px; border:0px; background:gray;margin-bottom:10px;margin-top:5px;}  
tr{ background:#bbc0c8;}  
td{ padding: 5px;}  
#title{ text-align:center;}  
.s{float:right;}
.i{width:300px;height:100px;margin-bottom:10px;}
.l{width:60px;}
.d{width:300px;height:300px;margin-left:100px;margin-top:20px;}
</style>
</head>
<body>
<h1>学生主界面</h1>
<a href="http://localhost:8080/ClassManageSystem/announceComment.jsp"><span class="s">查看详情</span></a>
<form action="Logout" method="post">
<input type="submit" name="" value="注销"/>
</form>
<jsp:useBean id="student" class="model.Student"  scope="session">
</jsp:useBean>
<p>欢迎您：</p>
<%  
 //连接MySQL数据库   
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();  
    String url="jdbc:odbc:welcome";  
  //  String user="root";  
   // String password="1234";  
    Connection conn = DriverManager.getConnection(url,"" , "");  
    Statement st = conn.createStatement();  
      
 %>  
    <table >  
  <tr>  
  <td width="61" id="title">公告id</td>  
    <td width="174" id="title">标题</td>  
    <td width="219" id="title">内容</td>  
    <td width="161" id="title">时间</td>  
     <td width="161" id="title">发布者</td>  
  </tr>  
      
<%  
    //把表格第二行的显示放到while循环中，就可以根据查询结果画出表格了。参数则放在<td>内的相应位置。  
    ResultSet rs = st.executeQuery("SELECT * FROM announce ORDER BY announceID");  
 // if(rs.next()){           //取第一个结果集
  	while(rs.next()){  //取所有的结果集
  
  %>  
      
  <tr>  
   <td width="74" ><%=rs.getString("announceID") %></td>  
    <td width="174" ><%=rs.getString("announceTitle") %></td>  
    <td width="249" ><%=rs.getString("details") %></td>  
    <td width="161"><%=rs.getString("time") %></td>  
     <td width="61"><%=rs.getString("name") %></td>  
     
  </tr>  
  
<%}  
//注意"}"的位置 %>  
 </table>  
  
<%  
    rs.close();  
    conn.close();  
 %>   

<form method="post" action="AddComment" >
<div class="d">
<label  for="announceID">输入公告id：</label>
<input class="l" type="text" name="announceID" ><br>
<label for="details">输入评论内容：</label>
<input class="i"  type="text" name="cdetails" ><br>
<label for="studentID">输入学号：</label>
<input class="l"  type="text" name="studentID" ><br>


<input type="submit" name="Submit" value="发布">
</div>

</form>




</body>

</html>