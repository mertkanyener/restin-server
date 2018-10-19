package com.mertkan.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import com.mertkan.model.Project;
import com.mertkan.model.URL;
import com.mertkan.service.ProjectService;
import com.mertkan.service.UrlService;
import com.mertkan.service.UserService;

@RestController
@RequestMapping(path="/admin")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	UrlService urlService;
	
	@Autowired
	UserService userService;
	
	@PostMapping(path = "/projects")
	public void save(@RequestBody Project project) {
		projectService.save(project);
	}
	
	@GetMapping(path = "/users/{username}")
	public Long getUserId(@PathVariable String username) {
		Long userId = this.userService.findByUsername(username).getId();
		return userId;
	}
	
	@GetMapping(path = "/projects/maxId")
	public Long getMaxProjectId() {
		return projectService.getMaxId();
	}
	
	@GetMapping(path = "/projects/all")
	public List<Project> getAllProjects() {
		return projectService.getAll();
	}
	
	@GetMapping(path = "/projects")
	public List<Project> getProjects(@RequestHeader(value="UserId") Long id) {
		return projectService.getProjects(id);
	}
	
	@DeleteMapping(path = "/projects/{id}")
	public void deleteProject(@PathVariable Long id) {
		projectService.delete(id);
	}
	
	@PutMapping(path = "/projects/{id}")
	public void updateProject(@PathVariable Long id, @RequestBody Project project) {
		project.setId(id);
		projectService.save(project);
	}
	
	@GetMapping(path = "/projects/{id}")
	public Project getProject(@PathVariable Long id) {
		return projectService.findByProjectId(id);
	}
	
	@GetMapping(path = "/{name}")
	public Project getProjectByName(@PathVariable String name, @RequestHeader(value="UserId") Long userId) {
		return projectService.findByProjectName(userId, name);
	}
	
	
	// "/urls" Mappings
	
	@GetMapping(path = "/urls/maxId")
	public Long getMaxUrlId() {
		return urlService.getMaxId();
	}
	
	@GetMapping(path = "/projects/{projectId}/urls")
	public List<URL> getUrls(@PathVariable Long projectId){
		return urlService.findByProjectId(projectId);
	}
	
	@GetMapping(path = "/projects/{projectId}/urls/{id}")
	public URL getUrl(@PathVariable Long projectId, @PathVariable Long id) {
		return urlService.findByUrlId(id);
	}
	
	@PostMapping(path = "/projects/{projectId}/urls")
	public void saveUrl(@PathVariable Long projectId, @RequestBody URL url) {
		url.setProjectId(projectId);
		urlService.save(url);
	}
	
	@PutMapping(path = "/projects/{projectId}/urls/{id}")
	public void updateUrl(@PathVariable Long projectId, @PathVariable Long id, @RequestBody URL url) {
		url.setId(id);
		url.setProjectId(projectId);
		urlService.save(url);
	}
	
	@DeleteMapping(path = "/projects/{projectId}/urls/{id}")
	public void deleteUrl(@PathVariable Long projectId, @PathVariable Long id) {
		urlService.delete(id);
	}
	
	@GetMapping(path = "/{projectName}/{path}/**")
	public String getResponse(@PathVariable String projectName, @PathVariable String path, 
							  @RequestHeader(value="UserId") Long userId, @RequestHeader(value="Code") Long code,
							  HttpServletRequest req) {
		final String reqPath = 
				req.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE).toString();
		final String bestMatchingPattern = 
				req.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE).toString();
		String rest = new AntPathMatcher().extractPathWithinPattern(bestMatchingPattern, reqPath); // determining the pattern-mapped part of URL
	    String output;
	    if (null != rest && !rest.isEmpty()) {
	        output = path + '/' + rest;
	    } else {
	        output = path;
	    }
		Long projectId = projectService.findByProjectName(userId, projectName).getId();
		return urlService.getResponse(projectId, output, code, "GET");		
	}
	
	@PostMapping(path = "/{projectName}/{path}/**")
	public String getPostResponse(@PathVariable String projectName, @PathVariable String path, 
							  @RequestHeader(value="UserId") Long userId, @RequestHeader(value="Code") Long code,
							  HttpServletRequest req) {
		final String reqPath = 
				req.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE).toString();
		final String bestMatchingPattern = 
				req.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE).toString();
		String rest = new AntPathMatcher().extractPathWithinPattern(bestMatchingPattern, reqPath); // determining the pattern-mapped part of URL
	    String output;
	    if (null != rest && !rest.isEmpty()) {
	        output = path + '/' + rest;
	    } else {
	        output = path;
	    }
		Long projectId = projectService.findByProjectName(userId, projectName).getId();
		return urlService.getResponse(projectId, output, code, "POST");		
	}
	
	@PutMapping(path = "/{projectName}/{path}/**")
	public String getPutResponse(@PathVariable String projectName, @PathVariable String path, 
							  @RequestHeader(value="UserId") Long userId, @RequestHeader(value="Code") Long code,
							  HttpServletRequest req) {
		final String reqPath = 
				req.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE).toString();
		final String bestMatchingPattern = 
				req.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE).toString();
		String rest = new AntPathMatcher().extractPathWithinPattern(bestMatchingPattern, reqPath); // determining the pattern-mapped part of URL
	    String output;
	    if (null != rest && !rest.isEmpty()) {
	        output = path + '/' + rest;
	    } else {
	        output = path;
	    }
		Long projectId = projectService.findByProjectName(userId, projectName).getId();
		return urlService.getResponse(projectId, output, code, "PUT");		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
