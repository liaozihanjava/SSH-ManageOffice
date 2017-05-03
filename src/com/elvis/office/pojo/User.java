package com.elvis.office.pojo;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "office")

public class User implements java.io.Serializable {

	// Fields

	@Override
	public String toString() {
		return "User [userid=" + userid + ", password=" + password + ", name=" + name + ", level=" + level + ", phone="
				+ phone + ", email=" + email + ", photo=" + photo + ", lastlogin=" + lastlogin + ", lockflag="
				+ lockflag + "]";
	}

	private String userid;
	private Role role;
	private String password;
	private String name;
	private Integer level;
	private String phone;
	private String email;
	private String photo;
	private Date lastlogin;
	private Integer lockflag;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userid, String password, String name, Integer level) {
		this.userid = userid;
		this.password = password;
		this.name = name;
		this.level = level;
	}

	/** full constructor */

	// Property accessors
	@Id

	@Column(name = "userid", unique = true, nullable = false, length = 50)

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rid")

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "password", nullable = false, length = 32)

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "name", nullable = false, length = 50)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "level", nullable = false)

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Column(name = "phone", length = 50)

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "email", length = 50)

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "photo", length = 200)

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Column(name = "lastlogin", length = 19)

	public Date getLastlogin() {
		return this.lastlogin;
	}

	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}

	@Column(name = "lockflag")

	public Integer getLockflag() {
		return this.lockflag;
	}

	public void setLockflag(Integer lockflag) {
		this.lockflag = lockflag;
	}


}