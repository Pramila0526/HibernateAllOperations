package com.bridgelabz.crudprograms.HibernatePrograms;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddStudent {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class);
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();

		Transaction transaction=session.beginTransaction();
		Query query = session.createQuery(" from Student ");

		Student s = new Student();
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Student Id");
		s.setSid(scan.nextInt());
		System.out.println("Enter the Student Name");
		s.setSname(scan.next());
		System.out.println("Enter the Student Marks");
		s.setMarks(scan.nextInt());
		
		session.save(s);
		transaction.commit();
		System.out.println("insert..................");
}
}
