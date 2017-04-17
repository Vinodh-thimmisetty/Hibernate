package com.vinodh.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceProvider;

import org.hibernate.Hibernate;
import org.hibernate.cfg.Configuration;

import com.vinodh.hibernate.JavaBrainsHibernate.UserDetails;

public class JPAExample {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("Eclipselink_JPA");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	entityManager.getTransaction().begin();
	
	UserDetails details = new UserDetails();
	details.setId(123);
	details.setName("JPA Example");
	details.setDescription("Hello Busy People");
	
	entityManager.persist(details);
	entityManager.getTransaction().commit();
	entityManager.close();
	entityManagerFactory.close();
}
}
