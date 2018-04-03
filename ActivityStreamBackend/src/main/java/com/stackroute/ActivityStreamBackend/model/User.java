package com.stackroute.ActivityStreamBackend.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;

@Entity
@Component
public class User extends ResourceSupport implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private String	emailId;
	private String	password;
	transient private String cPassword;
	private String	name;
	private boolean active;
	private String address;
	private String phoneNo;
	
	public User()
	{
		
	}
	public User(String name, String password, String emailId, String phoneNo, boolean active) {
		this.name = name;
		this.password = password;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.active = active;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getcPassword() {
		return cPassword;
	}

	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}

