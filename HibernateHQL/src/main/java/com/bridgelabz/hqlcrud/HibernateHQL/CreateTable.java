package com.bridgelabz.hqlcrud.HibernateHQL;
import java.util.Random;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
/***************************************************************************************************************************
 * @author :Pramila0526 
 * Purpose :To Create the Table Using HQL
 *
 **************************************************************************************************************************/
@SuppressWarnings("deprecation")
public class CreateTable {
	public static void main(String[] args) {

		// 4 We can create object of configuration because it is a class
		Configuration configuration = new Configuration().configure().addAnnotatedClass(StudentData.class);

		@SuppressWarnings("deprecation")
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

		Random random = new Random();

		for (int i = 0; i < 50; i++) {
			StudentData student = new StudentData();
			student.setSid(i);
			student.setSname("Name " + i);
			student.setMarks(random.nextInt(100));
			// 1 Storing data into the database
			session.save(student);
		}
		transaction.commit();
	}
}
