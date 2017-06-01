package action;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.NotFoundException;
import model.Announce;


/*继承扩展抽象类HttpServlet*/
public class FindAnnounceById extends HttpServlet{
		/*重写service()方法*/
	public void service (HttpServletRequest req,HttpServletResponse res) throws 
	IOException,ServletException{
		String address;
		/*从客户端html页面的<form>标记中文本框里获取信息announceTitle*/
		String announceID=req.getParameter("announceID"); //announceTitle是文本框的名字
		Announce aAnnounce=null;
		/*为响应client建立一个字符输出流，生成HTTP相应内容*/
		PrintWriter output=res.getWriter();
		//设置返回给客户端的显示格式id
		res.setContentType("text/html");
		//处理请求任务

		try{
		
			aAnnounce=Announce.find(announceID);
			
			//嵌入HTML代码，格式化一个输出响应
			output.println("<h3>Record found<br>"+"主题："+aAnnounce.getAnnounceTitle()+"<br>"+"公告内容:"
					+ aAnnounce.getDetails()+"!<h3>");
			address="FoundAnnounce.jsp";
			res.sendRedirect(address);
		}
		catch(NotFoundException e){
			output.println("<h3>没有找到该主题<h3>");
			address="FoundAnnounce.jsp";
			res.sendRedirect(address);
		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//		req.setAttribute("announce", aAnnounce);  //放置实例变量到req对象中
//		address="FoundAnnounce.jsp";
//		res.sendRedirect(address);
		/*关闭输出流，释放资源*/
		output.close();
	
	}  
}  
