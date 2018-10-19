package com.mertkan.service;

import java.util.List;

import com.mertkan.model.Project;

public interface ProjectService {
	
	void save(Project project);
	void delete(Long id);
	void update(Project project);
	List<Project> getAll();
	List<Project> getProjects(Long userId);
	Project findByProjectId(Long id);
	Project findByProjectName(Long userId, String name);
	Long getMaxId();
	
	

}
