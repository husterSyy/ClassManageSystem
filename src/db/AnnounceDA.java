package db;
import java.sql.*;
import java.text.DateFormat;
import java.util.Date;
import model.Admin;
import model.Announce;

public class AnnounceDA {
	static String url="jdbc:odbc:welcome";
	static Connection aConnection;
	static Statement aStatement;
	static String announceTitle,details;
	static String time;
	static String name;
	 static String studentID;
	static Announce aAnnounce;
	static Admin aAdmin;
	static String announceID;
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
	
	public static void add(Announce aAnnounce) throws DuplicateException{
		announceTitle=aAnnounce.getAnnounceTitle();
		details=aAnnounce.getDetails();
		time=aAnnounce.getTime();
		announceID=aAnnounce.getAnnounceID();
		name=aAnnounce.getAdmin().getName();
		studentID=aAnnounce.getAdmin().getStudentID();
	
//		Date rq = new Date();
//		 DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
//		  time = df.format(rq);
		 
		String sql="insert into announce values('"+announceTitle+"','"+details+"','"+time+"','"+name+"','"+studentID+"','"+announceID+"')";
	try{
		Announce anno=find(details);
		throw (new DuplicateException("该公告已存在"));
	}
	catch(NotFoundException e){
		try{
			int result=aStatement.executeUpdate(sql);
		}
		catch(SQLException ee)
		{
			System.out.println(ee);
		}
	}
	}
	
	public static void delete(Announce aAnnounce){
		announceID=aAnnounce.getAnnounceID();
		String sql="delete from announce where announceID='"+announceID+"'";
		
		try{
			int result=aStatement.executeUpdate(sql);
			
		}
		catch(SQLException e){
			System.out.println(e);
		}
	}
	
	public static void update(Announce aAnnounce) throws NotFoundException{
		announceTitle=aAnnounce.getAnnounceTitle();
		details=aAnnounce.getDetails();
		announceID=aAnnounce.getAnnounceID();
		time=aAnnounce.getTime();
		name=aAnnounce.getAdmin().getName();
		String sql="update announce set announceTitle='"+announceTitle+"',"
				+"details='"+details+"'"+"time='"+time+"'"
				+ "where announceID='"+announceID+"'";
		
		try{
		//	Announce anno=find(announceID);
			int result=aStatement.executeUpdate(sql);
			
		}
		catch(SQLException e){
			System.out.println(e);
		}
	
	}

	
public static Announce find (String announceID) throws NotFoundException{
	  String name;
	  Admin admin=null;
		aAnnounce=new Announce();
		aAdmin=new Admin();
		String sql = "SELECT * FROM announce WHERE announceID='" +announceID+ "'";
	System.out.println(sql);
	try {
		ResultSet rs = aStatement.executeQuery(sql);
		boolean gotIt = rs.next();
		if (gotIt) {
		//	student.setId(rs.getInt(1));
			aAnnounce.setAnnounceTitle(rs.getString("announceTitle"));
			aAnnounce.setDetails(rs.getString("details"));
			aAnnounce.setTime(rs.getString("time"));
			aAdmin.setName(rs.getString("name"));
			aAdmin.setStudentID(rs.getString("studentID"));
			aAnnounce.setAnnounceID(rs.getString("announceID"));
		//	name=rs.getString(4);
			
//			try{
//				admin=Admin.find(name);
//				
//			}
//			catch(NotFoundException e){
//				System.out.println(e);
//			}
//			
			
			//aAnnounce.setAdmin(admin);
			
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
	return aAnnounce;


}

}
