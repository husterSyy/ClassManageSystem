package model;

import java.util.ArrayList;
import java.util.List;

import db.DuplicateException;
import db.NotFoundException;
import db.StudentDA;

public class Student {
	//private int id; //班级成员编号
	private String studentID;//班级成员学号
	private String password;//登录密码
	private String name;//姓名
	private ArrayList<Comment> list=new ArrayList<Comment>();
	public Student( String studentID, String password, String name) {
	//super();
	
	//this.id = id;
	this.studentID = studentID;
	this.password = password;
	this.name = name;
	}
	public void addCommentToStudent(Comment aComment){
		
		list.add(aComment);
		aComment.setStudent(this);
	}
	public Student(){
		
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
	public ArrayList<Comment> getArrayList() {
		return list;
	}
	public void setArrayList(ArrayList<Comment> list) {
		this.list = list;
	}

	
//	public static Student findByID(int id) throws NotFoundException{
//		StudentDA.initialize();
//	
//	Student stu = StudentDA.findById(id);
//		StudentDA.terminate();
//		return stu;
//	}
	public void add() throws DuplicateException{
		StudentDA.initialize();
		StudentDA.add(this);
		StudentDA.terminate();
	}
 	public static Student find(String studentID) throws NotFoundException {
		StudentDA.initialize();
		Student stu = StudentDA.find(studentID);
		StudentDA.terminate();
		return stu;
	}
	public static Student find1(String name) throws NotFoundException {
		StudentDA.initialize();
		Student stu = StudentDA.find1(name);
		StudentDA.terminate();
		return stu;
	}
	public static Student find2(String studentID,String password) throws NotFoundException {
		StudentDA.initialize();
		Student stu = StudentDA.find2(studentID,password);
		StudentDA.terminate();
		return stu;
	}
}




