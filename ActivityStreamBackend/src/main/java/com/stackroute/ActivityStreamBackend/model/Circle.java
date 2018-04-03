package com.stackroute.ActivityStreamBackend.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Component
public class Circle extends ResourceSupport implements Serializable{

	@Id
	@Column(name="circleName")
	private String circleName;
	@Column(name="createdBy")
	private String createdBy;
	private boolean status;
	@Column(name="creationDate")
	@JsonFormat(pattern="dd-mm-yyyy hh:mm:ss")
	private Date creationDate;
	
	public Circle() {
		this.creationDate=new Date();
	}

	public Circle(String circleName, String createdBy, boolean status, Date creationDate) {
		this.circleName=circleName;
		this.createdBy=createdBy;
		this.status=status;
		this.creationDate=new Date();
	}

	public String getCircleName() {
		return circleName;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
}
