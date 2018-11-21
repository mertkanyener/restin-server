package com.mertkan.test;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.mertkan.model.Role;
import com.mertkan.repository.RoleRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoleRepoTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Test
	public void whenFindRoleById_thenReturnRole() {
		Role test = new Role(3l, "Some Role");
		
		entityManager.persist(test);
		entityManager.flush();
		
		Role found = roleRepository.findRoleById(3l);
		
		assertThat(found, Matchers.<Role>is(test));
	}
}
