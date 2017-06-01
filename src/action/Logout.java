package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Student;
import db.DuplicateException;

public class Logout extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
	
		String	address ="userLogin.jsp"; //跳转到获取最近一条活动信息的servlet程序
		resp.sendRedirect(address);//重定向到指定页面
		
		}
	}
		

