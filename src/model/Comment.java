package model;

import java.util.Date;

import db.AnnounceDA;
import db.CommentDA;
import db.DuplicateException;
import db.NotFoundException;

public class Comment {
	private int id;
	private String cdetails;
	private String cname;
	private String ctime;
	private Student aStudent;
	private Announce aAnnounce;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCdetails() {
		return cdetails;
	}
	public void setCdetails(String details) {
		this.cdetails = details;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String time) {
		this.ctime = time;
	}
	
	public Comment(){
		
	}
	public Comment(String cdetails,String ctime,Student aStudent,Announce aAnnounce){
		//setId(id);
		setCdetails(cdetails);
		setCtime(ctime);
		setStudent(aStudent);
		setAnnounce(aAnnounce);
		aStudent.addCommentToStudent(this);
		aAnnounce.addCommentToAnnounce(this);
	}
	public void setStudent(Student aStudent) {
		this.aStudent=aStudent;
		
	}
	public Student getStudent(){
		return aStudent;
	}
	public void setAnnounce(Announce aAnnounce) {
		this.aAnnounce=aAnnounce;
		
	}
	public Announce getAnnounce(){
		return aAnnounce;
	}
	
	public void add() throws DuplicateException{
		CommentDA.initialize();
		CommentDA.add(this);
		CommentDA.terminate();
	}
	public void delete() throws NotFoundException{
		CommentDA.initialize();
		CommentDA.delete(this);
		CommentDA.terminate();
	}
}
