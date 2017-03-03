package com.vinodh.hibernate.JavaBrainsHibernate;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * One-Many Relationship
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
@Entity(name = "USER_FRIENDS")
public class Friends {
	@Id
	@GeneratedValue
	private int freindId;
	@Column
	private String friendName;

	@ManyToOne
	@JoinColumn(name="USER_ID_FORIEGN_KEY")
	// If no vehicle is owned by USER, ignore the User Details
	@NotFound(action=NotFoundAction.IGNORE)
	private UserInfo info;
	
	@ManyToMany(mappedBy="friends")
	private Collection<GirlFriends> girlFriends ;
	 
	public Collection<GirlFriends> getGirlFriends() {
		return girlFriends;
	}

	public void setGirlFriends(Collection<GirlFriends> girlFriends) {
		this.girlFriends = girlFriends;
	}

	public UserInfo getInfo() {
		return info;
	}

	public void setInfo(UserInfo info) {
		this.info = info;
	}

	public Friends() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getFreindId() {
		return freindId;
	}

	public void setFreindId(int freindId) {
		this.freindId = freindId;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

}
