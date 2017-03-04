package com.vinodh.hibernate.JavaBrainsHibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="TECHNOLOGIES")
@DiscriminatorValue("TECH")
public class Developer extends ProjectVinodh {
	
	private String technology;

	public Developer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}
	
}
