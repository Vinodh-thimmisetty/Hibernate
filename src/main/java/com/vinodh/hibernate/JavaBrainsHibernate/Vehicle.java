package com.vinodh.hibernate.JavaBrainsHibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * one-one Relationship
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
@Entity(name="VEHICLE")
public class Vehicle {
	@Id
	@GeneratedValue
	private int vehicleId;
	@Column
	private String vehicleName;

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

}
