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

import com.mertkan.model.URL;
import com.mertkan.repository.UrlRepository;
import com.mertkan.service.UrlService;
import com.mertkan.service.UrlServiceImpl;

@RunWith(SpringRunner.class)
public class UrlServiceTest {
	
	@TestConfiguration
	static class UrlServiceImplTestContextConfiguration {
		@Bean
		public UrlService urlService() {
			return new UrlServiceImpl();
		}
	}
	
	@Autowired
	private UrlService urlService;
	
	@MockBean
	private UrlRepository urlRepository;
	
	@Before
	public void setUp() {
		List<URL> testList = new ArrayList<URL>();
		URL test1 = new URL(5l, 3l, "some/path", "{response}", 200, "GET", 0, 0);
		URL test2 = new URL(6l, 3l, "some/path/path", "{response}", 200, "POST", 0, 0);
		URL test3 = new URL(7l, 3l, "some/path/someother", "{response}", 200, "PUT", 0, 0);
		testList.add(test1);
		testList.add(test2);
		testList.add(test3);
		
		Mockito.when(urlRepository.findByUrlId(test1.getId())).thenReturn(test1);
		Mockito.when(urlRepository.findByProjectId(test1.getProjectId())).thenReturn(testList);
		Mockito.when(urlRepository.getUrl(test3.getProjectId(), test3.getPath(), test3.getResponseCode(), test3.getMethod())).thenReturn(test3);
	}
	
	@Test
	public void whenValidId_thenUrlShouldBeFound() {
		Long id = 5l;
		URL found = urlService.findByUrlId(id);
		assertThat(found.getId(), Matchers.<Long>is(id));
	}
	
	@Test
	public void whenValidProjectId_thenUrlsShouldBeFound() {
		Long projectId = 3l;
		List<URL> found = urlService.findByProjectId(projectId);
		for (URL url: found) {
			assertThat(url.getProjectId(), Matchers.<Long>is(projectId));
		}
	}
	
	@Test
	public void whenValidParams_thenReturnResponse() {
		String response = "{response}";
		Long projectId  = 3l;
		int responseCode = 200;
		String path = "some/path/someother";
		String method = "PUT";
		
		URL test3 = new URL(7l, 3l, "some/path/someother", "{response}", 200, "PUT", 0, 0);
		
		URL found = urlService.getUrl(projectId, path, responseCode, method);
		assertThat(found.getResponse(), Matchers.<String>is(test3.getResponse()));
	}

}
