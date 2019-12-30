package com.bridgelabz.mappingprograms.controller;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import com.bridgelabz.mappingprograms.model.Laptop;
import com.bridgelabz.mappingprograms.model.StudentDetails;
/***************************************************************************************************************************
 * @author :Pramila0526 
 * Purpose :Code To describe One TO One RelationShips 
 *
 **************************************************************************************************************************/
public class OneToOne 
{
    public static void main( String[] args )
    {
       Laptop laptop = new Laptop();
       laptop.setLid(4);
       laptop.setLname("HP");
       
       StudentDetails student=new StudentDetails();
       student.setSid(104);
       student.setSname("Sandhya");
       student.setMarks(95);
       student.setLaptop(laptop);
       
       Configuration configuration = new Configuration().configure().addAnnotatedClass(StudentDetails.class).addAnnotatedClass(Laptop.class);
		
  	 	ServiceRegistry servicereg=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

  		// 3 again we cannot create object of SessionFactory because SessionFactory
  		// so create Configuration object
  		SessionFactory sessionfactory = configuration.buildSessionFactory(servicereg);
  		
  		// 2 we cannot create object of session because session is an Interface
  		// so create SessionFactory object
  		Session session = sessionfactory.openSession();
  		
  		// Whenever you want to save any data into the database you make changes
  		// and whenever you make changes you have to follow ACID Properties
  		// So all these changes should be a part of transactions
  		Transaction transaction=session.beginTransaction();
  		
  		// 1 Storing data into the database
  		session.save(laptop);
  		session.save(student); 
  		
  		transaction.commit();
    }
}
