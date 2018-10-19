package com.mertkan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mertkan.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	
	@Query("SELECT DISTINCT project FROM Project project WHERE project.id= :id")
	Project findByProjectId(@Param("id") Long id);
	@Query("SELECT DISTINCT project FROM Project project WHERE project.userId= :userId")
	List<Project> getProjects(@Param("userId") Long userId);
	@Query("SELECT max(project.id) FROM Project project")
	Long getMaxId();
	@Query("SELECT DISTINCT project FROM Project project WHERE project.userId= :userId AND project.name= :name")
	Project findByProjectName(@Param("userId") Long userId, @Param("name") String name);
	

}
