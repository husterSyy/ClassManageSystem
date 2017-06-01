package action;

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

import model.Announce;
import model.Comment;
import model.Student;
import db.DuplicateException;
import db.NotFoundException;

public class AddComment extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); //显示中文无乱码
		String cname;
		String announceID,cdetails;
		String ctime;
		String address=null;
	    Student aStudent;
		String studentID;

		Comment aComment;
		Announce aAnnounce=null;
		HttpSession session = req.getSession();//获取session 保存数据
		announceID = req.getParameter("announceID");
	
		cdetails=req.getParameter("cdetails");
		studentID=req.getParameter("studentID");
	
			java.text.DateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	        ctime = format1.format(new Date());
		
		
			try{
			Student	student=Student.find(studentID);
				aStudent=new Student(student.getStudentID(),student.getPassword(),student.getName());
				try{	
					aComment=new Comment(cdetails,ctime,aStudent,aAnnounce);
					aComment.add();
					session.setAttribute("comment", aComment); //保存数据到session中，以便在前台获取到数据
					address ="mainPageStudent.jsp"; //跳转到获取最近一条活动信息的servlet程序
					resp.sendRedirect(address);//重定向到指定页面
			}
					catch(DuplicateException e){
						System.out.println(e);
						resp.setContentType("text/html;charset=utf-8");
						PrintWriter out = resp.getWriter();
						out.println("<html><script>alert('你已评论过！');location.href='mainPageStudent.jsp'; </script></html>");
						out.close();
					}

			
			}
			catch(NotFoundException e){
				System.out.println(e);
			}
		}


	}	