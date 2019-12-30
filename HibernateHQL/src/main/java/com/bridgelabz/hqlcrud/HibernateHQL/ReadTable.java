package com.bridgelabz.hqlcrud.HibernateHQL;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
/***************************************************************************************************************************
 * @author :Pramila0526 
 * Purpose :To Read the Table Using HQL
 *
 **************************************************************************************************************************/
@SuppressWarnings("deprecation")
public class ReadTable{
 	public static void main(String[] args) {

		// 4 We can create object of configuration because it is a class
		Configuration configuration = new Configuration().configure().addAnnotatedClass(StudentData.class);

		ServiceRegistry servicereg = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();

		// 3 again we cannot create object of SessionFactory because SessionFactory
		// so create Configuration object
		SessionFactory sessionfactory = configuration.buildSessionFactory(servicereg);

		// 2 we cannot create object of session because session is an Interface
		// so create SessionFactory object
		Session session = sessionfactory.openSession();
		
		// Whenevver you want to save any data into the database you make changes
		// and whenever you make changes you have to follow ACID Properties
		// So all these changes should be a part of transactions
		Transaction transaction = session.beginTransaction();
		
		Query query=session.createQuery("from StudentData where marks > 50"); 
		@SuppressWarnings("unchecked")
		List<StudentData> students=query.list();
		for(StudentData s:students)
		{
			System.out.println("Id       : " + s.getSid());
			System.out.println("Name     : " + s.getSname());
			System.out.println("Marks  : " + s.getMarks());
			System.out.println("------------------------------------");
		}
		transaction.commit();
		
		
		/**
		 * This code is For Fetching Only One Row Or Object
		 * 
		 *Query query=session.createQuery("select sid,sname,marks from StudentData where marks = 65"); 
		 *Object[] s=(Object[]) query.uniqueResult();  //uniqueResult is used Only for One Praticular Unique Row Or Object Or Data.
		 *
		 *System.out.println(s[0]+ ":" +s[1]+ ":" +s[2]);
		 */
		
		
		/**
		 * This code is For Fetching the Entire Table
		 * 
		 * Query query=session.createQuery("select sid,sname,marks from StudentData"); 
		 *List<Object[]> students=(List<Object[]>) query.list();
		
		 *for(Object[] s:students)
		 *{
		 *	System.out.println(s[0]+ ":" +s[1]+ ":" +s[2]);
		 *}
		 */
		

		/**
		 * This Code is For Prepared Statement Query 
		 * int b=70;
		 * Query query=session.createQuery("select sum(marks) from StudentData s where s.marks > :b"); 
		 * query.setParameter("b",b);
		 * Long s=(Long) query.uniqueResult();  //uniqueResult is used Only for One Particular Unique Row Or Object Or Data.
		 *System.out.println(s);
		 */
	}
}
