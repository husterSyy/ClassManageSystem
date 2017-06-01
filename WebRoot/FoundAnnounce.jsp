<%@ page language="java" import="java.util.*, java.sql.*" pageEncoding="gb2312"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<%request.setCharacterEncoding("UTF-8");%>   
<%response.setCharacterEncoding("UTF-8");%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告与评论</title>
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
    <td width="449" id="title">内容</td>  
    <td width="161" id="title">发布时间</td>  
     <td width="61" id="title">发布者</td>  
     <td width="61" id="title">评论内容</td>  
     <td width="61" id="title">评论者</td>  
     <td width="61" id="title">评论时间</td> 
  </tr>  
      
<%  
	ResultSet rs1;
    //把表格第二行的显示放到while循环中，就可以根据查询结果画出表格了。参数则放在<td>内的相应位置。   
  
 	
 
 
    rs1=st.executeQuery("SELECT announceTitle,* FROM announce,comment WHERE announce.announceID=comment.announceID ");
  			 while(rs1.next()){
   %> 
   <tr> 
    <td width="61"><%=rs1.getString("announceTitle") %></td>
    <td width="61"><%=rs1.getString("details") %></td>
        <td width="61"><%=rs1.getString("time") %></td>
      <td width="61"><%=rs1.getString("name") %></td>
     
      
      
     	
       <td width="61"><%=rs1.getString("cdetails") %></td>
        <td width="61"><%=rs1.getString("cname") %></td>
        <td width="61"><%=rs1.getString("ctime") %></td>
       
        </tr>
      
        

 
  <%
  } %>

 </table>  
  
  
  
<%  
    rs1.close();  
    conn.close();  
 %>   
 <a  href="http://localhost:8080/ClassManageSystem/mainPageAdmin.jsp">返回</a>
</body>
</html>