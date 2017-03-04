package com.vinodh.hibernate.JavaBrainsHibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * 
 * Relationships
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
@Entity(name = "USER_INFORMATION")
public class UserInfo {

	@Id
	@GeneratedValue
	private int userId;
	@Column
	private String userName;

	// one-one mapping with vehicle
	@OneToOne
	@JoinColumn(name = "VEHICLE_ID")
	private Vehicle vehicle;

	public Vehicle getVehicle() {
		return vehicle;
	}

	// One-Many mapping with Friends with Foreign Keys, Cascade will make sure all its dependencies also saved.
	 //@OneToMany(mappedBy="info",cascade=CascadeType.PERSIST)
	@OneToMany(mappedBy="info")
	// TO create new Table for Mapping ::	@JoinTable(name="USER_VEHICLE",joinColumns=@JoinColumn(name="USER_ID"), inverseJoinColumns=@JoinColumn(name ="FRIEND_ID"))
	private Collection<Friends> friends;
 
	public Collection<Friends> getFriends() {
		return friends;
	}

	public void setFriends(Collection<Friends> friends) {
		this.friends = friends;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
