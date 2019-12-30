package com.bridgelabz.crudprograms.HibernatePrograms;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This class should allowed to store its object inside the database so use Entity
public class Student {
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
