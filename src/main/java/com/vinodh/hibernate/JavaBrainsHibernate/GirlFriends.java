package com.vinodh.hibernate.JavaBrainsHibernate;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "GIRL_FRIENDS")
public class GirlFriends {
	@Id
	@GeneratedValue
	private int girlId;
	@Column
	private String girlName;
	
	@ManyToMany
	private Collection<Friends> friends;
	

	public Collection<Friends> getFriends() {
		return friends;
	}

	public void setFriends(Collection<Friends> friends) {
		this.friends = friends;
	}

	public GirlFriends() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getGirlId() {
		return girlId;
	}

	public void setGirlId(int girlId) {
		this.girlId = girlId;
	}

	public String getGirlName() {
		return girlName;
	}

	public void setGirlName(String girlName) {
		this.girlName = girlName;
	}

}
