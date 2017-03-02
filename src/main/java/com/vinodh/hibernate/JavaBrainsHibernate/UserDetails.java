package com.vinodh.hibernate.JavaBrainsHibernate;

import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity(name = "USER_DETAILS")
@Table(name = "EMPLOYEE", schema = "VINODH")
public class UserDetails {
	@Id // surrogate key, no business use, hibernate can generate this
	@Column(name = "EMP_ID") // column name
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // default generated hibernate sequence
	private int id;
	/*
	 * @Id // natural key, which can bde used for authentication
	 * 
	 * @Column(name="EMAIL") private int emailId;
	 */@Column(name = "EMP_NAME")
	private String name;
	@Basic(fetch = FetchType.EAGER, optional = true)
	@Temporal(TemporalType.DATE) // TO format the DATE
	@Column(name = "DOB")
	private Date dateOfBirth;
	@Transient // to not save in DB
	private String iDontSaveinDB;
	@Lob // For extra large size values
	private String description;

	// Embedding Objects
	// use @EmbeddedId to use primary key as OBJECT
	@Embedded // To make relationships
	private Address address;
	// override emebedded objects
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET")),
			@AttributeOverride(name = "city", column = @Column(name = "HOME_CITY")) })
	private Address homeAddress;

	@ElementCollection // TO enable Collection Datatype
	@JoinTable(name = "EMPLOYEE_FRIENDS",
	joinColumns=@JoinColumn(name="EMP_ID")
	) // to change the join table configurations
	private List<String> friends;

	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name = "EMPLOYEE_ENEMIES",
	joinColumns=@JoinColumn(name="EMP_NUM")
	) // to change the join table configurations
 	@GenericGenerator(strategy="hilo",name="hilo-gen")
	// TO create new Column like index using hilo generator :: similar to ROWNUM
	@CollectionId(columns = { @Column(name="COUNT") }, generator = "hilo-gen", type = @Type(type="long"))
	 private List<String> enemies;
 	public List<String> getEnemies() {
		return enemies;
	}

	public void setEnemies(List<String> enemies) {
		this.enemies = enemies;
	}

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
