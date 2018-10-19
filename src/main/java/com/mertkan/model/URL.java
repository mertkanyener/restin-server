package com.mertkan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name= "URL")
public class URL {
	
	@Id
	@Column(name = "id", nullable = false, updatable = false) 
	private Long id;
	@Column(name = "projectId", nullable = false)
	private Long projectId;
	@Column(name = "path", nullable = false)
	private String path;
	@Column(name = "response", columnDefinition="CLOB NOT NULL")
	@Lob
	private String response;
	@Column(name = "responseCode")
	private Long responseCode; 
	@Column(name = "method", nullable = false)
	private String method;
	@Column(name = "is_protected", nullable = false)
	private boolean isProtected;
	
	
	//Getters and setters
	
	public boolean isProtected() {
		return isProtected;
	}
	public void setProtected(boolean isProtected) {
		this.isProtected = isProtected;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Long getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(Long responseCode) {
		this.responseCode = responseCode;
	}
	
}
