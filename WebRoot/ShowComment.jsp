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
<title>��ʾ����ҳ��</title>  
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
    <td width="449" id="title">��������</td>  
    <td width="161" id="title">����ʱ��</td>  
     <td width="161" id="title">������</td>  
  </tr>  
      
<%  
    //�ѱ��ڶ��е���ʾ�ŵ�whileѭ���У��Ϳ��Ը��ݲ�ѯ�����������ˡ����������<td>�ڵ���Ӧλ�á�  
    ResultSet rs = st.executeQuery("SELECT * FROM comment ORDER BY cname ");  
    while(rs.next()){%>  
      
  <tr>  
    <td width="174" ><%=rs.getString("id") %></td>  
    <td width="449" ><%=rs.getString("cdetails") %></td>  
    <td width="161"><%=rs.getString("cname") %></td>  
     <td width="61"><%=rs.getString("ctime") %></td>  
     
  </tr>  
  
<%}  
//ע��"}"��λ�� %>  
 </table>  
  
<%  
    rs.close();  
    conn.close();  
 %>   
</body>  
</html>  