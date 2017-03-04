package com.vinodh.hibernate.JavaBrainsHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProjectVinodhTest {

	public static void main(String[] args) {
		ProjectVinodh proj = new ProjectVinodh();
		proj.setProjectName("IOT");

		Developer developer = new Developer();
		developer.setProjectName("YoYo");
		developer.setTechnology("JAVA");

		Tester tester = new Tester();
		tester.setProjectName("Haha");
		tester.setTools("Selenium");

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction(); 
		session.save(proj);
		session.save(developer);
		session.save(tester);
		session.getTransaction().commit();
		session.close();
	}

}
