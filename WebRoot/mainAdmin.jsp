<%@ page contentType="text/html" pageEncoding="GB2312" language="java"%>  
<%@ page import="java.sql.*"%>  
<html>  
    <head>  
        <title>hello</title>  
    </head>  
    <body>  
    <table border="1" spacing="2">  
<%!  
    public static final String DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";  
  //  public static final String USER = "root";  
   // public static final String PASS = "12345";  
    public static final String URL = "jdbc:odbc:welcome";  
    public static final int PAGESIZE = 5;  
    int pageCount;  
    int curPage = 1;  
%>  
<%  
    //一页放5个  
  //  String user = null;  
  //  String pass = null;  
    try{  
        Class.forName(DRIVER);  
        Connection con = DriverManager.getConnection(URL,"","");  
        String sql = "SELECT * FROM announce ORDER BY id";  
        PreparedStatement stat = con.prepareStatement(sql,ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);  
        ResultSet rs = stat.executeQuery();  
        rs.last();  
        int size = rs.getRow();  
        pageCount = (size%PAGESIZE==0)?(size/PAGESIZE):(size/PAGESIZE+1);  
        String tmp = request.getParameter("curPage");  
        if(tmp==null){  
            tmp="1";  
        }  
        curPage = Integer.parseInt(tmp);  
        if(curPage>=pageCount) curPage = pageCount;  
        boolean flag = rs.absolute((curPage-1)*PAGESIZE+1);  
        out.println(curPage);  
        int count = 0;  
          
        do{  
            if(count>=PAGESIZE)break;  
            String announceTitle = rs.getString(1);  
            String details = rs.getString(2);  
          // Date time = rs.getDate(3);  
          String time=rs.getString(3);
            String name=rs.getString(4);
            //Date hiredate = rs.getDate(4);  
        //    float sal = rs.getFloat(5);  
          //  int comm = rs.getInt(6);  
            count++;  
            %>  
        <tr>  
            <td><%=announceTitle%></td>  
            <td><%=details%></td>  
            <td><%=time%></td>  
            <td><%=name%></td>  
          
        </tr>  
            <%  
        }while(rs.next());  
        con.close();  
    }  
    catch(Exception e){  
          System.out.println(e);
    }  
%>  
</table>  
<a href = "mainAdmin.jsp?curPage=1" >首页</a>  
<a href = "mainAdmin.jsp?curPage=<%=curPage-1%>" >上一页</a>  
<a href = "mainAdmin.jsp?curPage=<%=curPage+1%>" >下一页</a>  
<a href = "mainAdmin.jsp?curPage=<%=pageCount%>" >尾页</a>  
第<%=curPage%>页/共<%=pageCount%>页  
  
</body>  
</html>  