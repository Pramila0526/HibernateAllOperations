package com.bridgelabz.mappingprograms.model;
/***************************************************************************************************************************
 * @author :Pramila0526 
 * Purpose :Many Teachers can have many Students
 *
 **************************************************************************************************************************/
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Teachers {
	@Id
	private int tid;
	private String tname;
	private String subject;
	@ManyToMany
	private List<Students> students=new ArrayList<Students>();
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public List<Students> getStudents() {
		return students;
	}
	public void setStudents(List<Students> students) {
		this.students = students;
	}
	
}
