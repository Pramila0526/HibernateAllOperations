package com.bridgelabz.crudprograms.HibernatePrograms;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ReadStudent {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class);
		
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			
			Session session = sessionFactory.openSession();

			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery(" from Student ");

			System.out.println("=========Students details=========\n");

			List<Student> list = q.list();
			for (Student s : list) {
				System.out.println("Id       : " + s.getSid());
				System.out.println("Name     : " + s.getSname());
				System.out.println("Address  : " + s.getMarks());
			
				System.out.println("------------------------------------");
			}
			
			
			transaction.commit();
		
		sessionFactory.close();
	}
}