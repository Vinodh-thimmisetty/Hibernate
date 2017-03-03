package com.vinodh.hibernate.JavaBrainsHibernate;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserInfoTest {

	public static void main(String[] args) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName("Mappings One-One");

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		userInfo.setVehicle(vehicle);
		
		Friends friends = new Friends();
		friends.setFriendName("Jaffa");
		Friends friends2 = new Friends();
		friends2.setFriendName("Yo Yo Jaffa");
		
		 Collection<Friends> collection = new ArrayList<Friends>();
		 collection.add(friends);
		 friends.setInfo(userInfo);
		 collection.add(friends2);
		 friends2.setInfo(userInfo);
		 
		 userInfo.setFriends(collection);
		 
		 GirlFriends girls = new GirlFriends();
		  girls.setGirlName("Aish");
		girls.setFriends(collection);
		  GirlFriends girls2 = new GirlFriends();
		  girls2.setGirlName("Alish");
			girls2.setFriends(collection);
		
	Collection<GirlFriends> colln = new ArrayList<GirlFriends>();
	colln.add(girls);
		 	colln.add(girls2);
	friends.setGirlFriends(colln);	
	friends2.setGirlFriends(colln);
		  
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		System.out.println("session opened");
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(userInfo);
		session.save(vehicle);
		session.save(friends);
		session.save(friends2); 
		session.save(girls);
		session.save(girls2);
		session.getTransaction().commit();
		session.close();

	}

}
