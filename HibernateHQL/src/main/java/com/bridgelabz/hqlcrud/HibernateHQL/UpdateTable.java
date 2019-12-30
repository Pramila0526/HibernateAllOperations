package com.bridgelabz.hqlcrud.HibernateHQL;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
/*************************************************************************************************************************
 * @author 	:Pramila0526
 * Purpose	:To Update the Table Using HQL
 *
 *************************************************************************************************************************/
@SuppressWarnings("deprecation")
public class UpdateTable{
	public static void main(String[] args) {

		// 4 We can create object of configuration because it is a class
		Configuration configuration = new Configuration().configure().addAnnotatedClass(StudentData.class);

		ServiceRegistry servicereg = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
									
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
		
		Query query = session.createQuery("update StudentData s set s.sname=? where s.sid=1");
		query.setParameter(0,"Pramila");
		int res = query.executeUpdate();
		
		//Commiting the Transaction
		transaction.commit();
	}
}
