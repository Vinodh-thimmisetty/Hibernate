package com.vinodh.hibernate.JavaBrainsHibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserTest {

	public static void main(String[] args) {
		System.out.println("main method");

		UserDetails details = new UserDetails();
		// details.setId(1);
		details.setName("Vinodh");
		details.setDateOfBirth(new Date());
		details.setDescription("I am not limited to String size of varchar2(255)");

		Address address = new Address();
		address.setCity("chennai");
		address.setStreet("shols");
		details.setAddress(address);

		Address homeAddress = new Address();
		homeAddress.setCity("kodur");
		homeAddress.setStreet("thimmisetty palli");
		details.setHomeAddress(homeAddress);
		
		List<String> frnds= new ArrayList<String>();
		frnds.add("abc");
		frnds.add("123");
		frnds.add("#@$#@");
		details.setFriends(frnds);
		
		UserDetails details2 = new UserDetails();
		// details.setId(1);
		details2.setName("Vinodh");
		details2.setDateOfBirth(new Date());
		details2.setDescription("I am not limited to String size of varchar2(255)");

		Address address2 = new Address();
		address2.setCity("chennai");
		address2.setStreet("shols");
		details2.setAddress(address2);

		Address homeAddress2 = new Address();
		homeAddress2.setCity("kodur");
		homeAddress2.setStreet("thimmisetty palli");
		details2.setHomeAddress(homeAddress2);
		
		List<String> frnds2= new ArrayList<String>();
		frnds2.add("abc");
		frnds2.add("123");
		frnds2.add("#@$#@");
		details2.setFriends(frnds2);
		
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		System.out.println("session opened");
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(details);
		session.save(details2);
		session.getTransaction().commit();
		session.close();
		/*
		 * System.out.println("session closed"); session =
		 * factory.openSession(); session.beginTransaction(); UserDetails
		 * userDetails = (UserDetails) session.get(UserDetails.class, 1);
		 * System.out.println(userDetails.getId());
		 */ }

}
