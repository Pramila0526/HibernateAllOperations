package com.bridgelabz.mappingprograms.model;
import javax.persistence.Entity;
import javax.persistence.Id;
/***************************************************************************************************************************
 * @author :Pramila0526 
 * Purpose :One Student can Have Only One Laptop
 * 
 **************************************************************************************************************************/
@Entity
public class Laptop {
	@Id
	private int lid;
	private String lname;
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", lname=" + lname + "]";
	}
}
