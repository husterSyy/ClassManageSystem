package action;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import model.Announce;
import db.DuplicateException;
import db.NotFoundException;

public class AddAnnounce extends HttpServlet {
	  
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); //显示中文无乱码
		String announceTitle, name,details,time;
		String announceID=null;
		
		String address=null;
		Announce aAnnounce=null;
		Admin aAdmin=null;
		
	ResultSet rs=null;
		 Connection conn=null;
		  Statement st=null;
		  
		HttpSession session = req.getSession();//获取session 保存数据
		announceID=req.getParameter("announceID");
		announceTitle = req.getParameter("announceTitle");
		details = req.getParameter("details");
		
	 
		java.text.DateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        time = format1.format(new Date());
//		Date rq = new Date();
//		 DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
//		 time = df.format(rq);
//		 
		 aAdmin=new Admin("U201517067","123456","syy");
//		name=req.getParameter("name");
//		announceID=req.getParameter("announceID");
		// name="syy";
		
		try {
					
						 aAnnounce=Announce.find(announceID); //查找是否有匹配的数据
						session.setAttribute("announce", aAnnounce); //保存数据到session中，以便在前台获取到数据
						//address = "mainPageStudent.jsp"; //跳转到获取最近一条活动信息的servlet程序
						resp.setContentType("text/html;charset=utf-8");
						PrintWriter out = resp.getWriter();
						out.println("<html><script>alert('该公告已被发表过！');location.href='mainPageAdmin.jsp'; </script></html>");
						out.close();
						resp.sendRedirect(address);//重定向到指定页面
						
						//resp.sendRedirect(req.getContextPath()+"/index.jsp");
					}
				catch (NotFoundException e1) {
						// TODO Auto-generated catch block

					try{   
						aAnnounce=new Announce(announceTitle,details,time,announceID,aAdmin);
						aAnnounce.add();
						session.setAttribute("announce", aAnnounce); //保存数据到session中，以便在前台获取到数据
					PrintWriter out = resp.getWriter();
					out.println("<html><script>alert('公告发布成功！');location.href='mainPageAdmin.jsp'; </script></html>");
						out.close();
						
//						address ="mainPageAdmin.jsp"; //跳转到获取最近一条活动信息的servlet程序
//						resp.sendRedirect(address);//重定向到指定页面
					}
					catch(DuplicateException ee){
							System.out.println(ee);
							resp.setContentType("text/html;charset=utf-8");
							PrintWriter out = resp.getWriter();
							out.println("<html><script>alert('该公告已被发表过！');location.href='mainPageAdmin.jsp'; </script></html>");
							out.close();
						}
				}
		
	
		}

		}
