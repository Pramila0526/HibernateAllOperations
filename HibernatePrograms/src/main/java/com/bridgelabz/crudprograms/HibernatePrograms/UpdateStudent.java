package com.bridgelabz.crudprograms.HibernatePrograms;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bridgelabz.crudprograms.utility.Utility;

public class UpdateStudent {
	static Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class);
	static SessionFactory sessionFactory = configuration.buildSessionFactory();

	static Session session = sessionFactory.openSession();

	static Transaction transaction = session.beginTransaction();

	public static int checkid(int id) {

		Query q = session.createQuery("from Student where Sid =" + id + " ");
		List<Student> list = q.list();
		
		for (Student s : list) {
			if (s.getSid() == id)

			{

				return 1;
			}
		}
		return id;
	}

	public static void main(String[] args) {

		Query qury = session.createQuery(" from Student ");

		Student student = new Student();

		System.out.println("Enter  Id");
		int id1 = Utility.integerInput();
		int value = checkid(id1);

		if (value > 0) {

			// s.setId(id);
			System.out.println("Enter the the Student Id");
			int sid = Utility.integerInput();

			System.out.println("Enter the Student Name");
			String sname = Utility.stringInput();

			System.out.println("Enter the Marks");
			int marks = Utility.integerInput();

			student.setSid(sid);
			student.setSname(sname);
			student.setMarks(marks);
			session.update(student);
			transaction.commit();
			session.close();
			System.out.println("Record Updated");

		}
	}
}
