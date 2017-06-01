<%@ page language="java" import="java.util.*, java.sql.*" pageEncoding="utf-8"%>  
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
<title>管理员主界面</title>
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
		 float:right;
}
table{ width:1000px; margin:auto; padding: 5px; font-size:12px; border:0px; background:gray;margin-bottom:10px;margin-top:5px;}  
tr{ background:#bbc0c8;}  
td{ padding: 5px;}  
#title{ text-align:center;}  
li{float:left;list-style:none;}
.b{width: ;height:100px;}
.i{width:300px;height:100px;margin-bottom:10px;}
.l{width:60px;}
.b1{width:400px;}
.b2{width:100px;}
.b3{width:400px;}
.b4{width:100px;}
</style>
</head>
<body>
<h1>管理员主界面</h1><a href="http://localhost:8080/ClassManageSystem/announceComment.jsp"><div class="s">查看详情</div></a>
<form action="Logout" method="post">
<input type="submit" name="" value="注销"/>
</form>
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
  <td width="150" id="title">公告id</td>  
    <td width="174" id="title">标题</td>  
    <td width="300" id="title">内容</td>  
    <td width="161" id="title">时间</td>  
  
  </tr>  
      
<%  
    //把表格第二行的显示放到while循环中，就可以根据查询结果画出表格了。参数则放在<td>内的相应位置。  
    ResultSet rs = st.executeQuery("SELECT * FROM announce ORDER BY announceID");  
 // if(rs.next()){           //取第一个结果集
  	while(rs.next()){  //取所有的结果集
  
  %>  
      
  <tr>  
   <td width="150" ><%=rs.getString("announceID") %></td>  
    <td width="174" ><%=rs.getString("announceTitle") %></td>  
    <td width="300" ><%=rs.getString("details") %></td>  
    <td width="161"><%=rs.getString("time") %></td>  
    
     
  </tr>  
  
<%}  
//注意"}"的位置 %>  
 </table>  
  
<%  
    rs.close();  
    conn.close();  
 %>   

<ul class="a">
<li class="b1">
<form method="post" action="UpdateAnnounce" >
<label  for="announceID">输入公告id：</label><br/>
<input class="l" type="text" name="announceID" ><br>
<label for="announceTitle">输入公告主题：</label><br/>
<input  type="text" name="announceTitle" ><br>
<label for="details">输入公告内容：</label><br/>
<input class="i" type="text" name="details" ><br>
<input type="submit" name="Submit" value="修改">
</form>
</li>
<li class="b2">
<form method=" " action="DeleteAnnounce" >
<label  for="announceID">输入公告id：</label><br/>
<input class="l" type="text" name="announceID" ><br>
<input type="submit" name="Submit" value="删除">
</form>
</li>
<li class="b3">
<form action="AddAnnounce" method="post" >
<label for="announceID">输入公告id：</label><br/>
<input class="l"  type="text" name="announceID" ><br>
<label for="announceTitle">输入公告主题：</label><br/>
<input type="text" name="announceTitle" ><br>
<label for="details">输入公告内容：</label><br/>
<input class="i" type="text" name="details" ><br>
<input type="submit" name="Submit" value="发布">
</form>
</li>
<li class="b4">
<form method="post" action="FindAnnounceById" >
<label  for="announceID">输入公告id：</label>
<input class="l" type="text" name="announceID" ><br>
<input type="submit" name="Submit" value="查询">
</form>
</li>
</ul>

</body>

</html>