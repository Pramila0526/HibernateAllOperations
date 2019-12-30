package com.bridgelabz.mappingprograms.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
/***************************************************************************************************************************
 * @author :Pramila0526 
 * Purpose :Many Employee can Belong to One Department
 *
 **************************************************************************************************************************/
@Entity
public class Employee {
	@Id
	private int empId;
	private String empName;
	private int salary;
	@ManyToOne     //Multiple employees Belongs to One Department
					// So With this Mapping will done in Employee Table
					// No Need to create extra table
	private Department department;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", department=" + department
				+ "]";
	}
	
}
