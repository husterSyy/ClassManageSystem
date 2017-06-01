package action;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import model.Announce;
import db.AnnounceDA;
import db.DuplicateException;
import db.NotFoundException;

public class UpdateAnnounce extends HttpServlet {
	  
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		
			String announceID;
			String address;
			Announce aAnnounce=null;
			announceID=req.getParameter("announceID");
		String	announceTitle=req.getParameter("announceTitle");
		String	details=req.getParameter("details");
//			if(announceID==""){
//		
//			res.setContentType("text/html;charset=utf-8");
//			PrintWriter out = res.getWriter();
//			out.println("<html><script>alert('请输入要修改的公告id！');location.href='mainPageAdmin.jsp'; </script></html>");
//			out.close();
//			}
		//	else{
			//	try{ 
					try{
						aAnnounce=AnnounceDA.find(announceID);
						aAnnounce.setAnnounceTitle(announceTitle);
						aAnnounce.setDetails(details);
						AnnounceDA.update(aAnnounce);
						res.setContentType("text/html;charset=utf-8");
			//			address="mainPageAdmin.jsp";
				//		res.sendRedirect(address);
						PrintWriter out = res.getWriter();
						out.println("<html><script>alert('修改成功！');location.href='mainPageAdmin.jsp'; </script></html>");
						out.close();
						
					}
					catch(NotFoundException e){
						System.out.println(e);
						res.setContentType("text/html;charset=utf-8");
						PrintWriter out = res.getWriter();
						out.println("<html><script>alert('找不到该公告！');location.href='mainPageAdmin.jsp'; </script></html>");
						out.close();
					}
				}
//				catch(Exception e){
//					e.printStackTrace();
//				}
//				req.setAttribute("announce", aAnnounce);
//				address="mainPageAdmin.jsp";
			}
//			RequestDispatcher dispatcher=req.getRequestDispatcher(address);
//			dispatcher.forward(req, res);
	//	}
	//}
	
