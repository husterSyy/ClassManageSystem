package action;

import java.io.IOException;
import java.io.PrintWriter;

//import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Student;
import db.NotFoundException;

public class LoginForStudent extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); //显示中文无乱码
		String studentID, password;
		String address=null;
		HttpSession session = req.getSession();//获取session 保存数据
		studentID = req.getParameter("studentID");//获取前台登录界面传来的学号
		password = req.getParameter("password");//获取前台登录界面传来的密码

		
		try {
			Student student=Student.find2(studentID, password); //查找是否有匹配的数据
			session.setAttribute("student", student); //保存数据到session中，以便在前台获取到数据
			address = "mainPageStudent.jsp"; //跳转到获取最近一条活动信息的servlet程序
			resp.sendRedirect(address);//重定向到指定页面
			
			//resp.sendRedirect(req.getContextPath()+"/index.jsp");
		}
	catch (NotFoundException e) {
			// TODO Auto-generated catch block

		System.out.println(e);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html><script>alert('学号或密码错误！');location.href='userLogin.jsp'; </script></html>");
		out.close();
	}
		}
	}
		
	
		

	
	
	
	
	

