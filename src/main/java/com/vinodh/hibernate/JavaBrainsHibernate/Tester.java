package com.vinodh.hibernate.JavaBrainsHibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "TESTER")
@DiscriminatorValue("TOOLS")
public class Tester extends ProjectVinodh {

	private String tools;

	public Tester() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTools() {
		return tools;
	}

	public void setTools(String tools) {
		this.tools = tools;
	}

}
