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
<title>����������</title>
</head>
<body>  
 <%  
 //����MySQL���ݿ�   
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();  
    String url="jdbc:odbc:welcome";  
  //  String user="root";  
   // String password="1234";  
    Connection conn = DriverManager.getConnection(url,"" , "");  
    Statement st = conn.createStatement();  
      
 %>  
    <table >  
  <tr>  
    <td width="174" id="title">����</td>  
    <td width="449" id="title">����</td>  
    <td width="161" id="title">����ʱ��</td>  
     <td width="61" id="title">������</td>  
     <td width="61" id="title">��������</td>  
     <td width="61" id="title">������</td>  
     <td width="61" id="title">����ʱ��</td> 
  </tr>  
      
<%  
	ResultSet rs1;
    //�ѱ��ڶ��е���ʾ�ŵ�whileѭ���У��Ϳ��Ը��ݲ�ѯ�����������ˡ����������<td>�ڵ���Ӧλ�á�   
  
 	
 
 
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
 <a  href="http://localhost:8080/ClassManageSystem/mainPageAdmin.jsp">����</a>
</body>
</html>