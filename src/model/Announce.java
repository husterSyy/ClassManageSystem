package model;

import java.sql.Date;
import java.util.ArrayList;

import db.AnnounceDA;
import db.DuplicateException;
import db.NotFoundException;
import db.StudentDA;

public class Announce {
	private String  announceTitle;
	private String details;
	private String time; 
	private String name;
	private Admin admin;
	private String studentID;
	private String announceID="0";
	private ArrayList<Comment>commentArray;
	
	public Announce(String announceTitle,String details,String time,String announceID,Admin admin){
	
		
		setTime(time);
		setAnnounceTitle(announceTitle);
		setDetails(details);
		setAdmin(admin);
		
		setAnnounceID(announceID);
		admin.addAnnounceToAdmin(this);
		commentArray=new ArrayList<Comment>(3);
	}
	
	public Announce(){
		
	}
	
	public ArrayList getComment(){
		return commentArray;
	}
	
	public void addCommentToAnnounce(Comment aComment) {
		commentArray.add(aComment);
		aComment.setAnnounce(this);
	}
	public Admin getAdmin(){
		return admin;
	}
	public void setAdmin(Admin admin){
		this.admin=admin;
	}
	public String getAnnounceID() {
		return announceID;
	}
	public void setAnnounceID(String announceID) {
		this.announceID = announceID;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	} 
	public String getAnnounceTitle() {
		return announceTitle;
	}
	public void setAnnounceTitle(String announceTitle) {
		this.announceTitle = announceTitle;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public static void initialize(){
		AnnounceDA.initialize();
	}
	public static void terminate(){
		AnnounceDA.terminate();
	}
	public static Announce find(String announceID) throws NotFoundException {

		AnnounceDA.initialize();
		Announce anno = AnnounceDA.find(announceID);
		AnnounceDA.terminate();
		return anno;
	}
	

	public void add() throws DuplicateException{
		AnnounceDA.initialize();
		AnnounceDA.add(this);
		AnnounceDA.terminate();
	}
	public void delete() throws NotFoundException{
		AnnounceDA.initialize();
		AnnounceDA.delete(this);
		AnnounceDA.terminate();
	}
	public void update() throws NotFoundException{
		AnnounceDA.initialize();
		AnnounceDA.update(this);
		AnnounceDA.terminate();
	}

	


	
	
}
