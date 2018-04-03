package com.stackroute.ActivityStreamBackend.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;

@Entity
@Component
public class WorkspaceUsers extends ResourceSupport implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int workspaceUsersId;
	private String companyName;
	private String userEmailId;
	private char status;
	
	public WorkspaceUsers() {
		
	}

	public int getWorkspaceUsersId() {
		return workspaceUsersId;
	}

	public void setWorkspaceUsersId(int workspaceUsersId) {
		this.workspaceUsersId = workspaceUsersId;
	}

	

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
	
	
}
