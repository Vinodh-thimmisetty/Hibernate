package com.vinodh.hibernate.JavaBrainsHibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Demonstrate CRUD operations
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
@Entity(name="CRUD")
@org.hibernate.annotations.Entity(selectBeforeUpdate=true) // Update only if any changes in object 
public class CRUDOperations {
	@Id
	@GeneratedValue
	private int id;
	private String name;

	@Transient
	private String transientVariable;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CRUDOperations() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
