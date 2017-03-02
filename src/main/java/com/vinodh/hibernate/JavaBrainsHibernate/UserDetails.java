package com.vinodh.hibernate.JavaBrainsHibernate;

import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;

@Entity(name = "USER_DETAILS")
@Table(name = "EMPLOYEE", schema = "VINODH")
public class UserDetails {
	@Id // surrogate key, no business use, hibernate can generate this
	@Column(name = "EMP_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	/*
	 * @Id // natural key, which can bde used for authentication
	 * 
	 * @Column(name="EMAIL") private int emailId;
	 */@Column(name = "EMP_NAME")
	private String name;
	@Basic(fetch = FetchType.EAGER, optional = true)
	@Temporal(TemporalType.DATE)
	@Column(name = "DOB")
	private Date dateOfBirth;
	@Transient
	private String iDontSaveinDB;
	@Lob
	private String description;

	// Embedding Objects
	// use @EmbeddedId to use primary key as OBJECT
 	@Embedded
	private Address address;
	// override emebedded objects
	@Embedded
	@AttributeOverrides(
			{
				@AttributeOverride(name = "street", column = @Column(name = "HOME_STREET")),
				@AttributeOverride(name = "city", column = @Column(name = "HOME_CITY")) 
			})
	private Address homeAddress;

	@ElementCollection 
	private List<String> friends;
	
	
	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	public Address getAddress() {
		return address;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public UserDetails() {
		super();
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
