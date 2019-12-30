package com.bridgelabz.mappingprograms.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
/***************************************************************************************************************************
 * @author :Pramila0526 
 * Purpose :One student can have only one laptop
 *
 **************************************************************************************************************************/

@Entity // This class should allowed to store its object inside the database so use Entity
public class StudentDetails {
	@Id  //Every table should have primary key
	private int sid;
	private String sname;
	private int marks;
	@OneToOne
	private Laptop laptop;
	
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
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	@Override
	public String toString() {
		return "StudentDetails [sid=" + sid + ", sname=" + sname + ", marks=" + marks + ", laptop=" + laptop + "]";
	}              
	
}
