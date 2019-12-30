package com.bridgelabz.crudprograms.dao;
import java.util.List;
import java.util.Scanner;
import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;

import com.bridgelabz.crudprograms.HibernatePrograms.Student;

public class Dao {

	static Session session;
	static Transaction t;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int ch;
		do {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		session = sf.openSession();
		t = session.beginTransaction();

	
			System.out.println("1.Add new user");
			System.out.println("2.Show");
			System.out.println("3.Delete");
			System.out.println("4.update");
			System.out.println("5.Search");
			System.out.println("6.Exit");
			System.out.println("Enter your choice");
			ch = scan.nextInt();
			switch (ch) {
			case 1:
				add_new_user();
				break;
			case 2:
				show();
				break;
			case 3:
				delete();
				break;
			case 4:
				update();
				break;
			case 5:
				search();
				break;
			case 6: {
				System.out.println("Existing");
				System.exit(0);
			}
			default:
				System.out.println("invalid choice..");
			}
		} while (ch != 6);

		t.commit();
		session.close();

	}

	public static void search() {

		System.out.println("Enter  Id");
		int search = scan.nextInt();
		Query q = session.createQuery(" from Student where Id =" + search + " ");
		
		 if(q==null)
		 {
			 System.out.println(q);
			 
		 }

		System.out.println("----------------Student details --------------------\n");

		List<Student> list = q.list();
		for (Student s : list) {
			System.out.println("Id       : "+s.getSid());
			System.out.println("Name     : "+s.getSname());
			System.out.println("Marks  : "+s.getMarks());
			System.out.println("------------------------------------");
		}

	}

	public static void update() {
		System.out.println("Enter  Id");
		int search = scan.nextInt();

	}

	public static void delete() {
		System.out.println("Enter  Id");
		int id = scan.nextInt();
		Student s=new Student();
		   String sql = "DELETE FROM Student WHERE id = "+id+"";
		   Query query = session.createQuery(sql);
	      int row = query.executeUpdate();
		if (row == 0)
			System.out.println("Doesnt deleted any row!");
		else
			System.out.println("Deleted Row: " + row);
	
	
			
		
	}

	public static void show() {
		

		Query q = session.createQuery(" from Student ");
		
		System.out.println("----------------Student details --------------------\n");

		List<Student> list = q.list();
		for (Student s : list) {
			System.out.println("Id       : "+s.getSid());
			System.out.println("Name     : "+s.getSname());
			System.out.println("Marks  : "+s.getMarks());
			System.out.println("------------------------------------");
		}

	}

	public static void add_new_user() {
		Student s = new Student();

		System.out.println("Enter the Student ID");
		s.setSid(scan.nextInt());

		System.out.println("Enter the Name");
		s.setSname(scan.next());
		System.out.println("Enter the age");
		s.setMarks(scan.nextInt());
		session.save(s);
		System.out.println(s.getSid());

		System.out.println("insert..................");

	}

}
