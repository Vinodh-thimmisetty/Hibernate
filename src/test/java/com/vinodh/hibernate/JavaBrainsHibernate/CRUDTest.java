package com.vinodh.hibernate.JavaBrainsHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CRUDTest {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction(); 

		for (int i = 1; i <= 10; i++) {
 			CRUDOperations operations = new CRUDOperations();
			operations.setName("USER-"+i); // It is in TRANSIENT State 
		// C- CREATE
			 // This is two step process a) Instantiate object (from TRANSIENT State) b) Pass Object to session Save (convert to Persist State)
			session.save(operations);   // It is in PERSISTENT State
	   // The Object will be update if it is in Persistent State and change any value in Object
			// Last Updated values will reflect in DB
			// operations.setName("USER-"+i+" Persistent state");
		}
	 	// R -READ
	 	CRUDOperations crudOperations = (CRUDOperations) session.get(CRUDOperations.class, 2);
  		System.out.println(crudOperations.getName() + " got from Saved DB");
  		// U- UPDATE
  		crudOperations.setName("Updated");
  		session.update(crudOperations);
  		// D- DELETE
  		session.delete(session.get(CRUDOperations.class, 4));
  		session.getTransaction().commit(); 
		 session.close();// It is in DETACHED State
  		// First Level Record , so no need of EAGER fetch,and LAZY is fine
  		// System.out.println(crudOperations.getName() + " got from Saved DB");
  	  	
		/**
		 *  TO Persist Detached Object 
		 */
		 crudOperations.setName("Name Updated after Session CLose");
		 session = factory.openSession();
		 session.beginTransaction();
		 session.update(crudOperations);
		 session.getTransaction().commit();
		 session.close();
		 
	}
}
