package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Admin;
import model.Announce;
import model.Comment;
import model.Student;

public class AdminDA {
	
		static Admin admin;
		static ArrayList<Announce> announceArray;
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
			public static Admin find(String studentID, String password)throws NotFoundException {
				admin = new Admin();
				announceArray = new ArrayList<Announce>();
				String sql = "SELECT * FROM admin WHERE studentID='" + studentID+ "' AND password='"
			+password + "'";
				System.out.println(sql);
				try {
					ResultSet rs = aStatement.executeQuery(sql);
					boolean gotIt = rs.next();
					if (gotIt) {
						//student.setId(rs.getInt(1));
						admin.setStudentID(rs.getString(1));
						admin.setPassword(rs.getString(2));
						admin.setName(rs.getString(3));
						
					}
					else {
						throw new NotFoundException("该用户不存在！");
					}
					rs.close();
				}
				catch(SQLException sqle){
					System.out.println(sqle);
				}
				return admin;

			}
		
			
			public static Admin find(String name)throws NotFoundException {
				admin= new Admin();
				announceArray = new ArrayList<Announce>();
				String sql = "SELECT * FROM admin WHERE name='" +name+ "'";
				System.out.println(sql);
				try {
					ResultSet rs = aStatement.executeQuery(sql);
					boolean gotIt = rs.next();
					if (gotIt) {
						//student.setId(rs.getInt(1));
						admin.setStudentID(rs.getString(1));
						admin.setPassword(rs.getString(2));
						admin.setName(rs.getString(3));
					}
					else {
						throw new NotFoundException("该用户不存在！");
					}
					rs.close();
				}
				catch(SQLException sqle){
					System.out.println(sqle);
				}
				return admin;

			}
			
			
			
			
			
}

