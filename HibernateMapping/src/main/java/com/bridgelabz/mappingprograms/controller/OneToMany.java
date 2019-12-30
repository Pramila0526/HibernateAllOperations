package com.bridgelabz.mappingprograms.controller;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import com.bridgelabz.mappingprograms.model.Department;
import com.bridgelabz.mappingprograms.model.Employee;
/***************************************************************************************************************************
 * @author :Pramila0526 
 * Purpose :Code To describe One To Many RelationShips 
 *
 **************************************************************************************************************************/
@SuppressWarnings("deprecation")
public class OneToMany 
{
    public static void main( String[] args )
    {
       Employee employee=new Employee();
       employee.setEmpId(4);
       employee.setEmpName("Krutika");
       employee.setSalary(56114);
       
       Department dept=new Department();
       dept.setDeptId(104);
       dept.setDeptName("IT");
       
       dept.getEmployee().add(employee);
       
       Configuration configuration = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class);
		
  	 	ServiceRegistry servicereg=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

  		// 3 again we cannot create object of SessionFactory because SessionFactory
  		// so create Configuration object
  		SessionFactory sessionfactory = configuration.buildSessionFactory(servicereg);
  		
  		// 2 we cannot create object of session because session is an Interface
  		// so create SessionFactory object
  		Session session = sessionfactory.openSession();
  		
  		// Whenevver you want to save any data into the database you make changes
  		// and whenever you make changes you have to follow ACID Properties
  		// So all these changes should be a part of transactions
  		Transaction transaction=session.beginTransaction();
  		
  		// 1 Storing data into the database
  		
  		session.save(dept); 
  		session.save(employee);
  		transaction.commit();
    }
}
