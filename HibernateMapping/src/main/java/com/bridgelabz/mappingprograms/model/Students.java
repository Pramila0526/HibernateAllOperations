package com.bridgelabz.mappingprograms.model;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
/***************************************************************************************************************************
 * @author :Pramila0526 
 * Purpose :Many Students Can Have Many Teachers
 *
 **************************************************************************************************************************/
@Entity
public class Students {
	@Id
	private int sid;
	private String sname;
	private int marks;
	@ManyToMany(mappedBy="students")
	private List<Teachers> teachers=new ArrayList<Teachers>();
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
	public List<Teachers> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teachers> teachers) {
		this.teachers = teachers;
	}
	
	
}
