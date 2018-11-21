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

import com.mertkan.model.URL;
import com.mertkan.repository.UrlRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UrlRepoTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UrlRepository urlRepository;
	
	@Test
	public void whenFindByUrlId_thenReturnUrl() {
		URL test = new URL(5l, 2l, "some/path", "{response}", 200, "GET", "application/json", true, 0);
		
		entityManager.persist(test);
		entityManager.flush();
		
		URL found = urlRepository.findByUrlId(5l);
		assertThat(found, Matchers.<URL>is(test));
	}
	
	@Test
	public void whenFindByProjectId_thenReturnUrl() {
		List<URL> testList = new ArrayList<URL>();
		URL test1 = new URL(5l, 3l, "some/path", "{response}", 200, "GET","application/json", true, 0);
		URL test2 = new URL(6l, 3l, "some/path", "{response}", 200, "GET","application/json", true, 0);
		URL test3 = new URL(7l, 3l, "some/path", "{response}", 200, "GET","application/json", true, 0);
		
		entityManager.persist(test1);
		entityManager.persist(test2);
		entityManager.persist(test3);
		entityManager.flush();
		
		testList.add(test1);
		testList.add(test2);
		testList.add(test3);
		
		List<URL> foundList = urlRepository.findByProjectId(3l);
		
		foundList.sort(Comparator.comparing(URL::getId));
		testList.sort(Comparator.comparing(URL::getId));
		
		assertThat(foundList, Matchers.<List<URL>>is(testList));
	}
	
	@Test
	public void whenMaxId_thenReturnMaxId() {
		URL test1 = new URL(5l, 3l, "some/path", "{response}", 200, "GET","application/json", true, 0);
		URL test2 = new URL(6l, 3l, "some/path", "{response}", 200, "GET","application/json", true, 0);
		URL test3 = new URL(777l, 3l, "some/path", "{response}", 200, "GET","application/json", true, 0);
		
		entityManager.persist(test1);
		entityManager.persist(test2);
		entityManager.persist(test3);
		entityManager.flush();
		
		Long found = urlRepository.maxId();
		
		assertThat(found, Matchers.<Long>is(test3.getId()));
		
	}
	
	@Test
	public void whenGetResponse_thenReturnResponse() {
		URL test = new URL(6l, 3l, "some/path", "{response}", 200, "GET","application/json", true, 0);
		
		entityManager.persist(test);
		entityManager.flush();
		
		URL found = urlRepository.getUrl(3l, "some/path", 200, "GET");
		
		assertThat(found, Matchers.<URL>is(test));
	}
}
