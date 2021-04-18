package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserInfo {
	
	@Id
	private long id;
	private String name;
	private String project;
	private long salary;
	private Date createdDate;
	
	
	
	public UserInfo(long id, String name, String project, long salary, Date createdDate) {
		super();
		this.id = id;
		this.name = name;
		this.project = project;
		this.salary = salary;
		this.createdDate = createdDate;
	}
	 public UserInfo() {
	    }
	 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	

}
