package com.lti.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="credentials")
public class Credential {
	@Id
	@Column(length=10,nullable=false)
	private String username;
	@Column(length=10,nullable=false)
	private String password;
	@Column(length=30,nullable=false)
	private String fullName;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
}
