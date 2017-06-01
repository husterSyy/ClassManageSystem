package action;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.NotFoundException;
import model.Announce;


/*�̳���չ������HttpServlet*/
public class FindAnnounceById extends HttpServlet{
		/*��дservice()����*/
	public void service (HttpServletRequest req,HttpServletResponse res) throws 
	IOException,ServletException{
		String address;
		/*�ӿͻ���htmlҳ���<form>������ı������ȡ��ϢannounceTitle*/
		String announceID=req.getParameter("announceID"); //announceTitle���ı��������
		Announce aAnnounce=null;
		/*Ϊ��Ӧclient����һ���ַ������������HTTP��Ӧ����*/
		PrintWriter output=res.getWriter();
		//���÷��ظ��ͻ��˵���ʾ��ʽid
		res.setContentType("text/html");
		//������������

		try{
		
			aAnnounce=Announce.find(announceID);
			
			//Ƕ��HTML���룬��ʽ��һ�������Ӧ
			output.println("<h3>Record found<br>"+"���⣺"+aAnnounce.getAnnounceTitle()+"<br>"+"��������:"
					+ aAnnounce.getDetails()+"!<h3>");
			address="FoundAnnounce.jsp";
			res.sendRedirect(address);
		}
		catch(NotFoundException e){
			output.println("<h3>û���ҵ�������<h3>");
			address="FoundAnnounce.jsp";
			res.sendRedirect(address);
		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//		req.setAttribute("announce", aAnnounce);  //����ʵ��������req������
//		address="FoundAnnounce.jsp";
//		res.sendRedirect(address);
		/*�ر���������ͷ���Դ*/
		output.close();
	
	}  
}  
