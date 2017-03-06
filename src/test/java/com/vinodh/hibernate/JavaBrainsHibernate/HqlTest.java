package com.vinodh.hibernate.JavaBrainsHibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 * Use Object i.e., CLASS names in Queries in HQL
 * 
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
public class HqlTest {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		/*
		 * for (int i = 1; i <= 10; i++) { HQLTable hqlTable = new HQLTable();
		 * hqlTable.setName("USER-" + i); session.save(hqlTable); }
		 * 
		 */
		int testId = 15;
		Query query = session.createQuery("from TESTDATA where id < :testId"); 
		// Named Query to put all common queries in one place	  
		//Query query = session.getNamedQuery("Testdata.byId"); // this can be used for antive sql queries too
		//query.setInteger(0, 5);
		// query = session.createQuery("select name from TESTDATA"); // IT will give list of Strings
		query.setFirstResult(2); // start
		query.setMaxResults(5); // number of records per page
		query.setParameter("testId", testId); // Parameter Binding to avoid SQL Injection
		List<HQLTable> emps = (List<HQLTable>) query.list();
		session.getTransaction().commit();
		session.close();
		for (HQLTable hqlTable : emps) {
			System.out.println(hqlTable.getName());
		}
		
		 System.out.println("----------------");
		/***
		 * 
		 *  CRITERIA API
		 */
			
		 session = factory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(HQLTable.class);
				 criteria.add(Restrictions.lt("id", 5));
				 criteria.addOrder(Order.desc("name"));
				 criteria.setFirstResult(0);
				 criteria.setMaxResults(5);
				 criteria.add(Restrictions.disjunction().add(Restrictions.lt("id", 10)).add(Restrictions.gt("id", 1)));
				 criteria.add(Restrictions.isNotNull("id"));
				 //criteria.setProjection(Projections.max("id")); // Aggregate
				 	// HQLTable yoo = new HQLTable();
					//yoo.setId(3);
					//yoo.setName("User-3");
					//Example example = Example.create(yoo).excludeProperty("name"); // not applicable for null or primary key property
				 	//criteria.add(example); 
						
				 List<HQLTable> hList=  (List<HQLTable>)criteria.list();
		session.getTransaction().commit();
		session.close();
 		for (HQLTable hqlTable : hList) {
			System.out.println(hqlTable.getName());
		}
	}

}
