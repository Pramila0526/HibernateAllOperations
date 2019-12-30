package com.bridgelabz.crudprograms.HibernatePrograms;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {
		// System.out.println("dszb");
		Student student1=new Student();
		student1.setSid(104);
		student1.setSname("Raj");
		student1.setMarks(54);

		// 4 We can create object of configuration because it is a class
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class);
		
	 //	ServiceRegistry servicereg=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

		// 3 again we cannot create object of SessionFactory because SessionFactory
		// so create Configuration object
		SessionFactory sessionfactory = configuration.buildSessionFactory();
		
		// 2 we cannot create object of session because session is an Interface
		// so create SessionFactory object
		Session session = sessionfactory.openSession();
		
		// Whenevver you want to save any data into the database you make changes
		// and whenever you make changes you have to follow ACID Properties
		// So all these changes should be a part of transactions
		Transaction transaction=session.beginTransaction();
		
		// 1 Storing data into the database
		session.save(student1); 
		
		transaction.commit();
	}
}
