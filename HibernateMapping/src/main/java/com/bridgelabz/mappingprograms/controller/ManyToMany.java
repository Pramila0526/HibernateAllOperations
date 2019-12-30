package com.bridgelabz.mappingprograms.controller;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import com.bridgelabz.mappingprograms.model.Students;
import com.bridgelabz.mappingprograms.model.Teachers;
/***************************************************************************************************************************
 * @author :Pramila0526 
 * Purpose :Code To describe Many To Many RelationShips 
 *
 **************************************************************************************************************************/
@SuppressWarnings("deprecation")
public class ManyToMany 
{
    public static void main( String[] args )
    {
       Students students = new Students();
       students.setSid(4);
       students.setSname("Vishal");
       students.setMarks(54);
      
       
       Teachers teachers=new Teachers();
       teachers.setTid(104);
       teachers.setTname("Sandhya");
       teachers.setSubject("Maths");
       
       teachers.getStudents().add(students);
       students.getTeachers().add(teachers);
       
       
       Configuration configuration = new Configuration().configure().addAnnotatedClass(Students.class).addAnnotatedClass(Teachers.class);
		
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
  		session.save(students);
  		session.save(teachers); 
  		
  		transaction.commit();
    }
}
