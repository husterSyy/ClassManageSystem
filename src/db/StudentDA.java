package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import model.Comment;
import model.Student;


	public class StudentDA {
		static Student student;
		static ArrayList<Comment> list;
		static Connection aConnection=null;
		static Statement aStatement=null;
		
		//static int id;
		static String studentID;
		static String name;
		static String password;
		
		static String url = "jdbc:odbc:welcome";//指定数据源datasource是ODBC中的数据源名
		public static Connection initialize() {
			try {
				//连接数据库
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				//创建一个与给定数据库url的连接
				aConnection = DriverManager.getConnection(url, "", "");
				aStatement = aConnection.createStatement();
			}
		catch (ClassNotFoundException cnfe) {
					System.out.println(cnfe);
					}

		catch (SQLException sqle) {
			System.out.println(sqle);
		
		}
			return aConnection ;
	}
		//关闭数据库连接
		public static void terminate() {
			try {
				aStatement.close();
				aConnection.close();
				
			}
			catch (SQLException e) {
					System.out.println(e);
				}
		}
			public static Student find(String studentID)throws NotFoundException {
				student = new Student();
				list = new ArrayList<Comment>();
				String sql = "SELECT * FROM student WHERE studentID='" + studentID+ "'";
				System.out.println(sql);
				try {
					ResultSet rs = aStatement.executeQuery(sql);
					boolean gotIt = rs.next();
					if (gotIt) {
						//student.setId(rs.getInt(1));
						student.setStudentID(rs.getString(1));
						student.setPassword(rs.getString(2));
						student.setName(rs.getString(3));
					}
					else {
						throw new NotFoundException("该用户不存在！");
					}
					rs.close();
				}
				catch(SQLException sqle){
					System.out.println(sqle);
				}
				return student;

			}
			public static Student find1(String name)throws NotFoundException {
				student = new Student();
				list = new ArrayList<Comment>();
				String sql = "SELECT * FROM student WHERE name='" + name+ "'";
				System.out.println(sql);
				try {
					ResultSet rs = aStatement.executeQuery(sql);
					boolean gotIt = rs.next();
					if (gotIt) {
						//student.setId(rs.getInt(1));
						student.setStudentID(rs.getString(1));
						student.setPassword(rs.getString(2));
						student.setName(rs.getString(3));
					}
					else {
						throw new NotFoundException("该用户不存在！");
					}
					rs.close();
				}
				catch(SQLException sqle){
					System.out.println(sqle);
				}
				return student;

			}
			public static Student find2(String studentID,String password)throws NotFoundException {
				student = new Student();
				list = new ArrayList<Comment>();
				String sql = "SELECT * FROM student WHERE studentID='" +studentID+ "' AND password='"+password+"'";
				System.out.println(sql);
				try {
					ResultSet rs = aStatement.executeQuery(sql);
					boolean gotIt = rs.next();
					if (gotIt) {
						//student.setId(rs.getInt(1));
						student.setStudentID(rs.getString(1));
						student.setPassword(rs.getString(2));
						student.setName(rs.getString(3));
					}
					else {
						throw new NotFoundException("该用户不存在！");
					}
					rs.close();
				}
				catch(SQLException sqle){
					System.out.println(sqle);
				}
				return student;

			}
			
			
			
			public static void add(Student aStudent)throws DuplicateException{
			//	id=aStudent.getId();
				studentID=aStudent.getStudentID();
				name=aStudent.getName();
				password=aStudent.getPassword();
				
				String sql="insert into student values ('"+studentID+"','"+password+"','"+name+"')";		
				System.out.println(sql);
				try{
					Student c=find1(studentID);
					throw(new DuplicateException("该用户已存在"));
				}
				
				catch(NotFoundException e){
					try{
						int result=aStatement.executeUpdate(sql);
					}
					catch(SQLException ee){
						System.out.println(ee);
					}
				}
			}
			
//			public static Student findById (int id) throws NotFoundException{
//				student = new Student();
//				list = new ArrayList<Comment>();
//				String sql = "SELECT * FROM student WHERE id='" + id+ "'";
//				System.out.println(sql);
//				try {
//					ResultSet rs = aStatement.executeQuery(sql);
//					boolean gotIt = rs.next();
//					if (gotIt) {
//					//	student.setId(rs.getInt(1));
//						student.setStudentID(rs.getString(1));
//						student.setPassword(rs.getString(3));
//						student.setName(rs.getString(2));
//					}
//					else {
//						throw new NotFoundException("该用户不存在！");
//					}
//					rs.close();
//				}
//				catch(SQLException sqle){
//					System.out.println(sqle);
//				}
//				return student;
//
//			
//			}
			
			
			
			
}