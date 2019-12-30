package com.bridgelabz.crudprograms.HibernatePrograms;

import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class);
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();

		Transaction transaction=session.beginTransaction();
		try {
			System.out.println("Enter Student Id");
			int id = scan.nextInt();
			transaction = session.beginTransaction();
	        Query q=session.createQuery("delete from student where sid=?");
	       q.setParameter(1, id);
	        int value=q.executeUpdate();
	        if(value>0)
	        {
	        	System.out.println("Record Deleted Success.......");
	        }
	        else
	        {
	        	System.out.println("Some Problem is there");
	        }
	        }catch(Exception e) {
	        	
	        	System.out.println(e);
	        }
	}

}
