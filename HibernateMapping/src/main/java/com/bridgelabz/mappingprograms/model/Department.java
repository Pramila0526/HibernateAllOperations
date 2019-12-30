package com.bridgelabz.mappingprograms.model;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/***************************************************************************************************************************
 * @author :Pramila0526 
 * Purpose :One Department can have Multiple Employess
 *
 **************************************************************************************************************************/
@Entity
public class Department {
	@Id
	private int deptId;
	private String DeptName;
	@OneToMany(mappedBy="department")    //One Department can have Multiple Number Of Employess
	private List<Employee> employee=new ArrayList<Employee>();
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return DeptName;
	}
	public void setDeptName(String deptName) {
		DeptName = deptName;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	
}
