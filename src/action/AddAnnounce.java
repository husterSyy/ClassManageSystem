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
		req.setCharacterEncoding("UTF-8"); //��ʾ����������
		String announceTitle, name,details,time;
		String announceID=null;
		
		String address=null;
		Announce aAnnounce=null;
		Admin aAdmin=null;
		
	ResultSet rs=null;
		 Connection conn=null;
		  Statement st=null;
		  
		HttpSession session = req.getSession();//��ȡsession ��������
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
					
						 aAnnounce=Announce.find(announceID); //�����Ƿ���ƥ�������
						session.setAttribute("announce", aAnnounce); //�������ݵ�session�У��Ա���ǰ̨��ȡ������
						//address = "mainPageStudent.jsp"; //��ת����ȡ���һ�����Ϣ��servlet����
						resp.setContentType("text/html;charset=utf-8");
						PrintWriter out = resp.getWriter();
						out.println("<html><script>alert('�ù����ѱ��������');location.href='mainPageAdmin.jsp'; </script></html>");
						out.close();
						resp.sendRedirect(address);//�ض���ָ��ҳ��
						
						//resp.sendRedirect(req.getContextPath()+"/index.jsp");
					}
				catch (NotFoundException e1) {
						// TODO Auto-generated catch block

					try{   
						aAnnounce=new Announce(announceTitle,details,time,announceID,aAdmin);
						aAnnounce.add();
						session.setAttribute("announce", aAnnounce); //�������ݵ�session�У��Ա���ǰ̨��ȡ������
					PrintWriter out = resp.getWriter();
					out.println("<html><script>alert('���淢���ɹ���');location.href='mainPageAdmin.jsp'; </script></html>");
						out.close();
						
//						address ="mainPageAdmin.jsp"; //��ת����ȡ���һ�����Ϣ��servlet����
//						resp.sendRedirect(address);//�ض���ָ��ҳ��
					}
					catch(DuplicateException ee){
							System.out.println(ee);
							resp.setContentType("text/html;charset=utf-8");
							PrintWriter out = resp.getWriter();
							out.println("<html><script>alert('�ù����ѱ��������');location.href='mainPageAdmin.jsp'; </script></html>");
							out.close();
						}
				}
		
	
		}

		}
