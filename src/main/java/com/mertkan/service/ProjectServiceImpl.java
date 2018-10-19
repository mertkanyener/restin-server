package com.mertkan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mertkan.model.Project;
import com.mertkan.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Override
	public void save(Project project) {
		projectRepository.save(project);
	}

	@Override
	public void delete(Long id) {
		projectRepository.deleteById(id);
	}

	@Override
	public void update(Project project) {
		projectRepository.save(project);
	}

	@Override
	public Project findByProjectId(Long id) {
		return projectRepository.findByProjectId(id);
	}

	@Override
	public List<Project> getAll() {
		return projectRepository.findAll();
	}
	
	@Override
	public List<Project> getProjects(Long userId) {
		return projectRepository.getProjects(userId);
	}
	
	@Override
	public Long getMaxId() {
		return projectRepository.getMaxId();
	}
	
	@Override
	public Project findByProjectName(Long userId, String name) {
		return projectRepository.findByProjectName(userId, name);
	}

}
