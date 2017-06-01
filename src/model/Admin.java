package model;

import java.util.ArrayList;
import java.util.List;

import db.AdminDA;
import db.DuplicateException;
import db.NotFoundException;
import db.StudentDA;


public class Admin {
	private String studentID;//班级成员学号
	private String password;//登录密码
	private String name;//姓名
	private ArrayList<Announce> announceArray;
	public Admin( String studentID, String password, String name) {
	//super();

	//this.id = id;
	this.studentID = studentID;
	this.password = password;
	this.name = name;
	announceArray=new ArrayList<Announce>(3);
	}
	
	public Admin(){
		
	}
	public ArrayList getAnnounces(){
		return announceArray;
	}
	public  void addAnnounceToAdmin(Announce aAnnounce){
		announceArray.add(aAnnounce);     //连接admin到announce（1...*)
		aAnnounce.setAdmin(this);  //连接announce到admin（1...1)
	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Announce> getArrayList() {
		return announceArray;
	}
	public void setArrayList(ArrayList<Announce> announceArray) {
		this.announceArray = announceArray;
	}
	public static Admin find(String studentID, String password) throws NotFoundException {

		AdminDA.initialize();
		Admin a = AdminDA.find(studentID,password);
		AdminDA.terminate();
		return a;
	}
	
//	public static Student findByID(int id) throws NotFoundException{
//		StudentDA.initialize();
//	
//	Student stu = StudentDA.findById(id);
//		StudentDA.terminate();
//		return stu;
//	}
	
	public static Admin find(String name) throws NotFoundException {
		AdminDA.initialize();
		Admin adm = AdminDA.find(name);
		AdminDA.terminate();
		return adm;
	}
}

