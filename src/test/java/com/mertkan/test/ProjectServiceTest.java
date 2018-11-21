package com.mertkan.test;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mertkan.model.Project;
import com.mertkan.repository.ProjectRepository;
import com.mertkan.service.ProjectService;
import com.mertkan.service.ProjectServiceImpl;

@RunWith(SpringRunner.class)
public class ProjectServiceTest {
	
	
	@TestConfiguration
	static class ProjectServiceImplTestContextConfiguration {
		@Bean
		public ProjectService projectService() {
			return new ProjectServiceImpl();
		}
	}
	
	@Autowired
	private ProjectService projectService;
	
	@MockBean
	private ProjectRepository projectRepository;
	
	@Before
	public void setUp() {
		List<Project> testList = new ArrayList<Project>();
	
		Project test = new Project(64l, 1l, "test", "something", "active");
		Project test2 = new Project(11l, 2l, "test2", "desc2", "active"); 
		Project test3 = new Project(12l, 2l, "test3", "desc3", "passive"); 
		Project test4 = new Project(13l, 2l, "test4", "desc4", "pending");
		
		testList.add(test2);
		testList.add(test3);
		testList.add(test4);
		
		Mockito.when(projectRepository.findByProjectId(test.getId())).thenReturn(test);
		Mockito.when(projectRepository.findByProjectName(test.getUserId(), test.getName())).thenReturn(test);
		Mockito.when(projectRepository.getProjects(test2.getUserId())).thenReturn(testList);
	}
	
	@Test
	public void whenValidId_thenProjectShouldBeFound() {
		Long id = 64l;
		Project found = projectService.findByProjectId(id);
		assertThat(found.getId(), Matchers.<Long>is(id));
	}
	
	@Test
	public void whenValidNameandId_thenProjectShouldBeFound() {
		Long userId = 1l;
		String name = "test";
		Project found = projectService.findByProjectName(userId, name);
		assertThat(found.getName(), Matchers.<String>is(name));
	}
	
	@Test
	public void whenValidUserId_thenProjectsShouldBeFound() {
		Long userId = 2l;
		List<Project> found = projectService.getProjects(userId);
		for (Project project : found) {
			assertThat(project.getUserId(), Matchers.<Long>is(userId));
		}
		
	}
	
}
