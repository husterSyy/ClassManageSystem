package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Student;
import db.DuplicateException;
import db.NotFoundException;

public class Register extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); //显示中文无乱码
		String studentID, name,password;
		String address=null;
		Student aStudent=null;
		HttpSession session = req.getSession();//获取session 保存数据
		studentID = req.getParameter("studentID");//获取前台登录界面传来的学号
		name=req.getParameter("name");
		password = req.getParameter("password");//获取前台登录界面传来的密码
			try {
					 aStudent=Student.find1(studentID); //查找是否有匹配的数据
					session.setAttribute("student", aStudent); //保存数据到session中，以便在前台获取到数据
					address = "userLogin.jsp"; //跳转到获取最近一条活动信息的servlet程序
					resp.sendRedirect(address);//重定向到指定页面
					
					//resp.sendRedirect(req.getContextPath()+"/index.jsp");
				}
			catch (NotFoundException e) {
					// TODO Auto-generated catch block
				try{
		       aStudent=new Student(studentID,password,name);
					
				aStudent.add();
				req.setAttribute("student",aStudent);
				address="userLogin.jsp";
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.println("<html><script>alert('注册成功！');location.href='userLogin.jsp'; </script></html>");
				out.close();
				}
				catch(DuplicateException ee){
					System.out.println(ee);
				}
				
			}
			//获得一个转发请求
		//	RequestDispatcher dispatcher=req.getRequestDispatcher(address);
			//dispatcher.forward(req, resp);//将响应消息转发给address指定的jsp文件
		
		
		
		
//		try{
//				aStudent=new Student(studentID,password,name);
//				aStudent.add();
//				session.setAttribute("student", aStudent); //保存数据到session中，以便在前台获取到数据
//				resp.setContentType("text/html;charset=utf-8");
//				PrintWriter out = resp.getWriter();
//				out.println("<html><script>alert('注册成功！');location.href='userLogin.jsp'; </script></html>");
//				out.close();
//				address ="studentLogin.jsp"; //跳转到获取最近一条活动信息的servlet程序
//				resp.sendRedirect(address);//重定向到指定页面
//		}
//				catch(DuplicateException e){
//					System.out.println(e);
//					resp.setContentType("text/html;charset=utf-8");
//					PrintWriter out = resp.getWriter();
//					out.println("<html><script>alert('你已注册过！');location.href='userLogin.jsp'; </script></html>");
//					out.close();
//				}
//		
		}
	}
		
