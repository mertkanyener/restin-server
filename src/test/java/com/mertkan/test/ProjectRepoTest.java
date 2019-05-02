package com.mertkan.test;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.mertkan.model.Project;
import com.mertkan.repository.ProjectRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProjectRepoTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ProjectRepository projectRepository; 
	
	@Test
	public void whenFindByProjectId_thenReturnProject() {
		Project test = new Project(964l, 1l, "test", "something", "active");
		entityManager.persist(test);
		entityManager.flush();
		
		Project found = projectRepository.findByProjectId(test.getId());
		assertThat(found, Matchers.<Project>is(test));
		
	}
	
	@Test
	public void whenGetProjects_thenReturnProjects() {
		List<Project> testList = new ArrayList<Project>();
		
		Project test1 = new Project(901l, 2l, "test1", "desc1", "active");
		Project test2 = new Project(911l, 2l, "test2", "desc2", "active");
		Project test3 = new Project(912l, 2l, "test3", "desc3", "passive");
		Project test4 = new Project(913l, 2l, "test4", "desc4", "pending");
		
		testList.add(test1);
		testList.add(test2);
		testList.add(test3);
		testList.add(test4);
		
		entityManager.persist(test1);
		entityManager.persist(test2);
		entityManager.persist(test3);
		entityManager.persist(test4);
		entityManager.flush();
	
		List<Project> foundList = projectRepository.getProjects(2l);

		foundList.sort(Comparator.comparing(Project::getId));
		testList.sort(Comparator.comparing(Project::getId));
		
		assertThat(foundList, Matchers.<List<Project>>is(testList));
	}
	
	@Test
	public void whenGetMaxId_thenReturnMaxId() {
		
		Project test1 = new Project(910l, 2l, "test1", "desc1", "active");
		Project test2 = new Project(911l, 2l, "test2", "desc2", "active");
		Project test3Max = new Project(999l, 2l, "test3", "desc3", "passive"); 
		Project test4 = new Project(913l, 2l, "test4", "desc4", "pending");
		
		entityManager.persist(test1);
		entityManager.persist(test2);
		entityManager.persist(test3Max);
		entityManager.persist(test4);
		entityManager.flush();
		
		Long found = projectRepository.getMaxId();
		
		assertThat(found, Matchers.<Long>is(test3Max.getId()));
		
	}
	
	@Test
	public void whenFindByProjectName_thenReturnProject() {
		Project test = new Project(920l, 3l, "aCoolProjectName", "desc", "active");
		
		entityManager.persist(test);
		entityManager.flush();
		
		Project found = projectRepository.findByProjectName(3l, test.getName());
		assertThat(found, Matchers.<Project>is(test));
	}
	

}
