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
	@Column(name= "isDynamic")
	private int isDynamic;
	@Column(name = "is_mirrored", nullable = false)
	private int isMirrored;
	
	public URL() {}
	
	public URL(Long id, Long projectId, String path, String response, int responseCode, String method, int isMirrored, int isDynamic) {
		super();
		this.id = id;
		this.projectId = projectId;
		this.path = path;
		this.response = response;
		this.responseCode = responseCode;
		this.method = method;
		this.isMirrored = isMirrored;
		this.isDynamic = isDynamic;

	}
	
	//Getters and setters
	
	public int getIsDynamic() {
		return isDynamic;
	}

	public void setIsDynamic(int isDynamic) {
		this.isDynamic = isDynamic;
	}
	
	public int isMirrored() {
		return isMirrored;
	}
	public void setMirrored(int isMirrored) {
		this.isMirrored = isMirrored;
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
	
	
}
