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
		req.setCharacterEncoding("UTF-8"); //��ʾ����������
		String studentID, name,password;
		String address=null;
		Student aStudent=null;
		HttpSession session = req.getSession();//��ȡsession ��������
		studentID = req.getParameter("studentID");//��ȡǰ̨��¼���洫����ѧ��
		name=req.getParameter("name");
		password = req.getParameter("password");//��ȡǰ̨��¼���洫��������
			try {
					 aStudent=Student.find1(studentID); //�����Ƿ���ƥ�������
					session.setAttribute("student", aStudent); //�������ݵ�session�У��Ա���ǰ̨��ȡ������
					address = "userLogin.jsp"; //��ת����ȡ���һ�����Ϣ��servlet����
					resp.sendRedirect(address);//�ض���ָ��ҳ��
					
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
				out.println("<html><script>alert('ע��ɹ���');location.href='userLogin.jsp'; </script></html>");
				out.close();
				}
				catch(DuplicateException ee){
					System.out.println(ee);
				}
				
			}
			//���һ��ת������
		//	RequestDispatcher dispatcher=req.getRequestDispatcher(address);
			//dispatcher.forward(req, resp);//����Ӧ��Ϣת����addressָ����jsp�ļ�
		
		
		
		
//		try{
//				aStudent=new Student(studentID,password,name);
//				aStudent.add();
//				session.setAttribute("student", aStudent); //�������ݵ�session�У��Ա���ǰ̨��ȡ������
//				resp.setContentType("text/html;charset=utf-8");
//				PrintWriter out = resp.getWriter();
//				out.println("<html><script>alert('ע��ɹ���');location.href='userLogin.jsp'; </script></html>");
//				out.close();
//				address ="studentLogin.jsp"; //��ת����ȡ���һ�����Ϣ��servlet����
//				resp.sendRedirect(address);//�ض���ָ��ҳ��
//		}
//				catch(DuplicateException e){
//					System.out.println(e);
//					resp.setContentType("text/html;charset=utf-8");
//					PrintWriter out = resp.getWriter();
//					out.println("<html><script>alert('����ע�����');location.href='userLogin.jsp'; </script></html>");
//					out.close();
//				}
//		
		}
	}
		
