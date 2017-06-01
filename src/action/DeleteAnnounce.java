package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.NotFoundException;
import model.Announce;

public class DeleteAnnounce extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		String announceID;
		String address;
		Announce aAnnounce=null;
		announceID=req.getParameter("announceID");
		if(announceID==""){
	
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<html><script>alert('请输入要删除的公告id！');location.href='mainPageAdmin.jsp'; </script></html>");
		out.close();
		}
	
			 
				try{
					aAnnounce=Announce.find(announceID);
					aAnnounce.delete();
				
					res.setContentType("text/html;charset=utf-8");
					PrintWriter out = res.getWriter();
					out.println("<html><script>alert('删除成功！');location.href='mainPageAdmin.jsp'; </script></html>");
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
			
//			req.setAttribute("announce", aAnnounce);
//			address="mainPageAdmin.jsp";
		}
//		RequestDispatcher dispatcher=req.getRequestDispatcher(address);
//		dispatcher.forward(req, res);
