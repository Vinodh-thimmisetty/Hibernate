package com.vinodh.hibernate.JavaBrainsHibernate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *  Inheritance in Hibernate ::
 *  1. Default is Single Table Strategy
 *  		All Classes in Inheritance Hierarchy will be listed in single Table  with new DTYPE column having class names
 *  2. Table per class:
 *  		Individual Classes for Each Class in Hierarchy
 *  3. Joined:
 *  		Individual classes + Super Class table will save its sub class details(instance variables) it is inherting
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
@Entity(name = "PROJECT_VINODH")
// @Inheritance(strategy=InheritanceType.SINGLE_TABLE) // This is Default 
// @Inheritance(strategy=InheritanceType.JOINED) 
// TO change the DTYPE value in Single Table Strategy type
 @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="VEHICLE_TYPE",discriminatorType=DiscriminatorType.STRING)
 public class ProjectVinodh {

	@Id
	@GeneratedValue
	private int projectId;
	@Column
	private String projectName;

	public ProjectVinodh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
 
}
