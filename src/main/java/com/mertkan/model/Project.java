package com.mertkan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Project")
public class Project {
	
	@Override
	public String toString() {
		return "Project [id=" + id + ", userId=" + userId + ", name=" + name + ", description=" + description
				+ ", status=" + status + "]";
	}
	@Id
	private Long id;
	@Column(name = "user_id", nullable = false)
	private Long userId;
	@Column(name = "name", nullable = false, updatable = true)
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "status")
	private String status;
//	@Column(name = "page")
//	private int page;
//
	public Project() {}
	
	public Project(Long id, Long userId, String name, String description, String status) {
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.description = description;
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

//	public int getPage() {
//		return page;
//	}
//
//	public void setPage(int page) {
//		this.page = page;
//	}






}
