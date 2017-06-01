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
		req.setCharacterEncoding("UTF-8"); //��ʾ����������
		String studentID, password;
		String address=null;
		HttpSession session = req.getSession();//��ȡsession ��������
		studentID = req.getParameter("studentID");//��ȡǰ̨��¼���洫����ѧ��
		password = req.getParameter("password");//��ȡǰ̨��¼���洫��������

		
		try {
			Student student=Student.find2(studentID, password); //�����Ƿ���ƥ�������
			session.setAttribute("student", student); //�������ݵ�session�У��Ա���ǰ̨��ȡ������
			address = "mainPageStudent.jsp"; //��ת����ȡ���һ�����Ϣ��servlet����
			resp.sendRedirect(address);//�ض���ָ��ҳ��
			
			//resp.sendRedirect(req.getContextPath()+"/index.jsp");
		}
	catch (NotFoundException e) {
			// TODO Auto-generated catch block

		System.out.println(e);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html><script>alert('ѧ�Ż��������');location.href='userLogin.jsp'; </script></html>");
		out.close();
	}
		}
	}
		
	
		

	
	
	
	
	

