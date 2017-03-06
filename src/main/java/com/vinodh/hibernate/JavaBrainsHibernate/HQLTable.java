package com.vinodh.hibernate.JavaBrainsHibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

@Entity(name="TESTDATA")
//@NamedQuery(name="Testdata.byId", query = "from HQLTable where userId = ?")
//@NamedNativeQuery(name="Testdata.byName", query="select name from TESTDATA where userName=?",resultClass=HQLTable.class )
public class HQLTable {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	public HQLTable() {
		super();
		// TODO Auto-generated constructor stub
	}
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

}
