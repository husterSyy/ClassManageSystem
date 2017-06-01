<%@ page language="java" import="java.util.*, java.sql.*" pageEncoding="gb2312"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<%request.setCharacterEncoding("UTF-8");%>   
<%response.setCharacterEncoding("UTF-8");%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">  
<html xmlns="http://www.w3.org/1999/xhtml">  
  
<style type="text/css">  
table{ width:800px; margin:auto; padding: 5px; font-size:12px; border:0px; background:#00CCFF;}  
tr{ background:#fff;}  
td{ padding: 5px;}  
#title{ text-align:center;}  
</style>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />  
<title>显示公告页面</title>  
</head>  
  
<body>  
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
    <td width="174" id="title">标题</td>  
    <td width="219" id="title">内容</td>  
    <td width="161" id="title">时间</td>  
     <td width="161" id="title">发布者</td>  
  </tr>  
      
<%  
    //把表格第二行的显示放到while循环中，就可以根据查询结果画出表格了。参数则放在<td>内的相应位置。  
    ResultSet rs = st.executeQuery("SELECT * FROM announce ORDER BY time");  
 // if(rs.next()){           //取第一个结果集
  	while(rs.next()){  //取所有的结果集
  
  %>  
      
  <tr>  
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
</body>  
</html>  