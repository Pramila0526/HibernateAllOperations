package com.bridgelabz.hqlcrud.HibernateHQL;
import javax.persistence.Entity;
import javax.persistence.Id;
/***************************************************************************************************************************
 * @author :Pramila0526 
 * Purpose :Pojo Class To Create the table
 *
 **************************************************************************************************************************/

@Entity // This class should allowed to store its object inside the database so use Entity
public class StudentData {
	@Id  //Every table should have primary key
	private int sid;
	private String sname;
	//@Column(name="student_marks") This is used to change the name of Column 
	private int marks;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	

}
