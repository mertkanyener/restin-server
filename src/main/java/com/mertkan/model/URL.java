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
	private int responseCode; 
	@Column(name = "method", nullable = false)
	private String method;
	@Column(name = "contentType")
	private String contentType;
	@Column(name= "isDynamic")
	private int isDynamic;
	@Column(name = "is_protected", nullable = false)
	private boolean isProtected;
	
	public URL() {}
	
	public URL(Long id, Long projectId, String path, String response, int responseCode, String method, String contentType,
			boolean isProtected, int isDynamic) {
		super();
		this.id = id;
		this.projectId = projectId;
		this.path = path;
		this.response = response;
		this.responseCode = responseCode;
		this.method = method;
		this.isProtected = isProtected;
		this.isDynamic = isDynamic;
		this.contentType = contentType;
		
	}
	
	//Getters and setters
	
	public int getIsDynamic() {
		return isDynamic;
	}

	public void setIsDynamic(int isDynamic) {
		this.isDynamic = isDynamic;
	}
	
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
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	
	
	
}
