package com.stackroute.ActivityStreamBackend.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Component
public class Workspace extends ResourceSupport implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int workspaceId;
	private String purpose;
	private String typeOfOrganisation;
	private int teamSize;
	private String role;
	private String companyName;
	private String adminEmailId;
	//@JsonFormat(pattern="dd-mm-yyyy hh:mm:ss")
	private Date creationDate;
	
	public Workspace() {
		creationDate=new Date();
	}

	public int getWorkspaceId() {
		return workspaceId;
	}

	public void setWorkspaceId(int workspaceId) {
		this.workspaceId = workspaceId;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getTypeOfOrganisation() {
		return typeOfOrganisation;
	}

	public void setTypeOfOrganisation(String typeOfOrganisation) {
		this.typeOfOrganisation = typeOfOrganisation;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAdminEmailId() {
		return adminEmailId;
	}

	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	
}
