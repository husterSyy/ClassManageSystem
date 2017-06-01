package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Announce;
import model.Student;
import model.Comment;

public class CommentDA {
	
	static String url="jdbc:odbc:welcome";
	static Connection aConnection;
	static Statement aStatement;
	static String cdetails;
	static String ctime;
	static String cname;
	 static String studentID;
	 static String announceID;
	 static Announce aAnnounce;
	 static Student aStudent;
	
	public static Connection initialize(){
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			aConnection=DriverManager.getConnection(url,"","");
			aStatement=aConnection.createStatement();
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(SQLException e){
			System.out.println(e);
		}
		return aConnection;
	}
	
	/*释放所有的资源*/
	public static void terminate(){
		try{
			aStatement.close();
			aConnection.close();
			
		}
		catch(SQLException e){
			System.out.println(e);
		}
	}
	
	public static void add(Comment aComment) throws DuplicateException{
	
		cdetails=aComment.getCdetails();
		ctime=aComment.getCtime();
		cname=aComment.getStudent().getName();
		studentID=aComment.getStudent().getStudentID();

		announceID=aComment.getAnnounce().getAnnounceID();
		String sql="insert into comment values('"+cdetails+"','"+ctime+"','"+cname+"','"+studentID+"','"+announceID+"')";
		
	
		try{
			int result=aStatement.executeUpdate(sql);
		}
		catch(SQLException ee)
		{
			System.out.println(ee);
		}
	}

	
	public static void delete(Comment aComment){
		cdetails=aComment.getCdetails();
		String sql="delete from comment where details='"+cdetails+"'";
		
		try{
			int result=aStatement.executeUpdate(sql);
			
		}
		catch(SQLException e){
			System.out.println(e);
		}
	}
	
	public static void update(Comment aComment) throws NotFoundException{
	
		cdetails=aComment.getCdetails();
		ctime=aComment.getCtime();
		cname=aComment.getStudent().getName();
		String sql="update comment set cdetails,set time='"
		+cdetails+"','"+ctime+"' where cdetails='"+cdetails+"','"+ctime+"'";
		
		try{
			Comment comm=find(cdetails);
			int result=aStatement.executeUpdate(sql);
			
		}
		catch(SQLException e){
			System.out.println(e);
		}
	
	}
	
	
	
	
	
	public static Comment find (String details) throws NotFoundException{
	  String name;
	  Comment aComment;
	  Student student=null;
		aComment=new Comment();
		aStudent=new Student();
		String sql = "SELECT * FROM comment WHERE cdetails='" + cdetails+ "'";
	System.out.println(sql);
	try {
		ResultSet rs = aStatement.executeQuery(sql);
		boolean gotIt = rs.next();
		if (gotIt) {
		//	student.setId(rs.getInt(1));
			aComment.setCdetails(rs.getString("cdetails"));
			aComment.setCtime(rs.getString("ctime"));
			aStudent.setName(rs.getString("cname"));
			
			aAnnounce.setAnnounceID(rs.getString("announceID"));
			name=rs.getString("cname");
			try{
				student=Student.find(name);
				
			}
			catch(NotFoundException e){
				System.out.println(e);
			}
			
			
			aComment.setStudent(student);
			//announceTitle=rs.getString(1);
			//aAnnounce=new Announce()
		}
		else {
			throw new NotFoundException("该公告不存在！");
		}
		rs.close();
	}
	catch(SQLException sqle){
		System.out.println(sqle);
	}
	return aComment;


}

}