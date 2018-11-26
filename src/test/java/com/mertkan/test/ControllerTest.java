package com.mertkan.test;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mertkan.Application;
import com.mertkan.model.Project;
import com.mertkan.model.URL;
import com.mertkan.service.ProjectService;
import com.mertkan.service.UrlService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ControllerTest {

    @Autowired
    WebApplicationContext context;
    @Autowired
    FilterChainProxy springSecurityFilterChain;
    MockMvc mvc;
    
    @MockBean
	private ProjectService projectService;
    
    @MockBean
    private UrlService urlService;
    
    

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context)
                .addFilter(springSecurityFilterChain).build();
    }
    
    // Projects tests
    
    @Test
	public void givenProjects_whenGetProjects_thenReturnJsonArray() throws Exception {
		List<Project> testList = createTestProjects();
		
		ObjectWriter ow = new ObjectMapper().writer();
		String expectedJson = ow.writeValueAsString(testList);
		System.out.println(expectedJson);

		when(projectService.getProjects(testList.get(0).getUserId())).thenReturn(testList);
		this.mvc.perform(get("/admin/projects")
				.header("Authorization", "Bearer " + getAccessToken())
				.header("UserId", 2l))
			.andExpect(status().isOk())
			.andExpect(content().string(expectedJson));
    }
    
    @Test
    public void whenGetMaxId_thenReturnMaxId() throws Exception {
    	Project test1 = new Project(999l, 6l, "test1", "desc1", "active");
    	when(projectService.getMaxId()).thenReturn(test1.getId());
    	
    	mvc.perform(get("/admin/projects/maxId")
    			.header("Authorization", "Bearer " + getAccessToken()))
    	.andExpect(status().isOk())
    	.andExpect(jsonPath("$", is(Math.toIntExact(test1.getId()))));
    }
    
    @Test
    public void whenGetAllProjects_thenReturnJsonArrray() throws Exception {
    	List<Project> testList = createTestProjects();
		
    	Project sql1 = new Project(1l, 1l, "memberbook", "This is a test", "Active");
    	Project sql2 = new Project(2l, 1l, "sqlTest", "This is another test", "Active");
		
    	testList.add(sql1);
		testList.add(sql2);
		
		ObjectWriter ow = new ObjectMapper().writer();
		String expectedJson = ow.writeValueAsString(testList);
		
		when(projectService.getAll()).thenReturn(testList);
		
		mvc.perform(get("/admin/projects/all")
				.header("Authorization", "Bearer " + getAccessToken()))
			.andExpect(status().isOk())
			.andExpect(content().string(expectedJson));
    }
    
    @Test
    public void givenProjectwhenGetProject_thenReturnJson() throws Exception {
    	
    	List<Project> testList = createTestProjects();
    	
    	ObjectWriter ow = new ObjectMapper().writer();
		String expectedJson = ow.writeValueAsString(testList.get(0));
		
		when(projectService.findByProjectId(testList.get(0).getId())).thenReturn(testList.get(0));
		
		mvc.perform(get("/admin/projects/"+Math.toIntExact(testList.get(0).getId()))
				.header("Authorization", "Bearer " + getAccessToken()))
			.andExpect(status().isOk())
			.andExpect(content().string(expectedJson));
    }
    
    @Test
    public void givenProjectWhenUpdateProject_thenResponseShouldBeOk() throws Exception{
    	
    	Project sql1 = new Project(2l, 1l, "sqlTest", "This is test", "passive");
    	
    	ObjectWriter ow = new ObjectMapper().writer();
    	String reqBody = ow.writeValueAsString(sql1);
    	
    	mvc.perform(put("/admin/projects/"+Math.toIntExact(sql1.getId()))
    			.header("Authorization", "Bearer " + getAccessToken())
    			.contentType(MediaType.APPLICATION_JSON)
    			.content(reqBody))
    	.andExpect(status().isOk());
    }
    
    @Test
    public void givenProjectWhenPostProject_thenResponseShouldBeOk() throws Exception {
    	Project sql1 = new Project(3l, 1l, "testProject", "This is test", "passive");
    	
    	ObjectWriter ow = new ObjectMapper().writer();
    	String reqBody = ow.writeValueAsString(sql1);
    	
    	mvc.perform(post("/admin/projects")
    			.header("Authorization", "Bearer " + getAccessToken())
    			.contentType(MediaType.APPLICATION_JSON)
    			.content(reqBody))
    	.andExpect(status().isOk());
    }
    
    @Test
    public void givenIdWhenDeleteProject_thenResponseShouldBeOk() throws Exception{
    	int id = 1;
    	
    	mvc.perform(delete("/admin/projects/"+id)
    			.header("Authorization", "Bearer " + getAccessToken()))
    	.andExpect(status().isOk());
    }
    
    @Test
    public void givenProjectNameWhenGetProject_thenReturnJson() throws Exception {
    	
    	Project test = new Project(10l, 2l, "mertProject", "desc1", "active");
    	
    	when(projectService.findByProjectName(test.getUserId(), test.getName())).thenReturn(test);
    	
    	ObjectWriter ow = new ObjectMapper().writer();
		String expectedJson = ow.writeValueAsString(test);
    	
    	mvc.perform(get("/admin/" + test.getName())
    			.header("Authorization", "Bearer " + getAccessToken())
    			.header("UserId", 2l))
    	.andExpect(status().isOk())
    	.andExpect(content().string(expectedJson));
    }
    
    // URL Tests
    
    @Test
    public void whenGetMaxUrlId_thenReturnMaxId() throws Exception {
    	URL test = new URL(5l, 3l, "some/path", "{response}", 200, "GET", "application/json", 0, 0);
    	
    	when(urlService.getMaxId()).thenReturn(test.getId());
    	
    	mvc.perform(get("/admin/urls/maxId")
    			.header("Authorization", "Bearer " + getAccessToken()))
    	.andExpect(status().isOk())
    	.andExpect(jsonPath("$", is(Math.toIntExact(test.getId()))));    	
    }
    
    @Test
    public void givenProjectIdWhenGetUrls_thenReturnJsonArray() throws Exception {
    	List<URL> testList = createTestUrls();
    	
    	ObjectWriter ow = new ObjectMapper().writer();
    	String expectedJson = ow.writeValueAsString(testList);
    	
    	when(urlService.findByProjectId(testList.get(0).getProjectId())).thenReturn(testList);
    	
    	mvc.perform(get("/admin/projects/" + Math.toIntExact(testList.get(0).getProjectId()) + "/urls")
    			.header("Authorization", "Bearer " + getAccessToken()))
    	.andExpect(status().isOk())
    	.andExpect(content().string(expectedJson));
    }
    
    @Test
    public void givenUrlWhenPostUrl_thenResponseShouldBeOk() throws Exception {
    	URL test = new URL(5l, 3l, "some/path", "{response}", 200, "GET", "application/json", 0, 0);
    	
    	ObjectWriter ow = new ObjectMapper().writer();
		String reqBody = ow.writeValueAsString(test);
		
		mvc.perform(post("/admin/projects/" + Math.toIntExact(test.getProjectId()) + "/urls")
				.header("Authorization", "Bearer " + getAccessToken())
				.contentType(MediaType.APPLICATION_JSON)
				.content(reqBody))
		.andExpect(status().isOk());
    	
    }
    
    @Test
    public void givenIdWhenGetUrl_thenReturnJson() throws Exception {
    	URL test = new URL(5l, 3l, "some/path", "{response}", 200, "GET", "application/json", 0, 0);
    	
    	ObjectWriter ow = new ObjectMapper().writer();
		String expectedJson = ow.writeValueAsString(test);
		
		when(urlService.findByUrlId(test.getId())).thenReturn(test);
		
		mvc.perform(get("/admin/projects/" + Math.toIntExact(test.getProjectId()) + "/urls/" + Math.toIntExact(test.getId()))
				.header("Authorization", "Bearer " + getAccessToken()))
		.andExpect(status().isOk())
		.andExpect(content().string(expectedJson));
    }
    
    @Test
    public void givenUrlWhenUpdateUrl_thenResponseShouldBeOk() throws Exception {
    	URL test = new URL(5l, 3l, "some/path", "{response}", 200, "application/json", "GET", 0, 0);
    	
    	ObjectWriter ow = new ObjectMapper().writer();
		String reqBody = ow.writeValueAsString(test);
		
		mvc.perform(put("/admin/projects/" + Math.toIntExact(test.getProjectId()) + "/urls/" + Math.toIntExact(test.getId()))
				.header("Authorization", "Bearer " + getAccessToken())
				.contentType(MediaType.APPLICATION_JSON)
				.content(reqBody))
		.andExpect(status().isOk());
    }
    
    @Test
    public void givenUrlIdWhenDeleteUrl_thenResponseShouldBeOk() throws Exception {
    	int urlId = 1;
    	int projectId = 1;
    	
    	mvc.perform(delete("/admin/projects/"+projectId + "/urls/"+ urlId)
    			.header("Authorization", "Bearer " + getAccessToken()))
    	.andExpect(status().isOk());
    }
    
    
    private List<Project> createTestProjects() {
    	List<Project> testList = new ArrayList<Project>();
    	
    	Project test1 = new Project(10l, 2l, "test1", "desc1", "active"); 
		Project test2 = new Project(11l, 2l, "test2", "desc2", "active"); 
		Project test3 = new Project(12l, 2l, "test3", "desc3", "passive"); 
		Project test4 = new Project(13l, 2l, "test4", "desc4", "pending");
		
		testList.add(test1);
		testList.add(test2);
		testList.add(test3);
		testList.add(test4);
    	
		return testList;
    }
    
    private List<URL> createTestUrls() {
    	
    	List<URL> testList = new ArrayList<URL>();
    	
    	URL test1 = new URL(5l, 3l, "some/path", "{response}", 200, "GET", "application/json", 0, 0);
		URL test2 = new URL(6l, 3l, "some/path", "{response}", 200, "GET", "application/json", 0, 0);
		URL test3 = new URL(7l, 3l, "some/path", "{response}", 200, "GET", "application/json", 0, 0);

		testList.add(test1);
		testList.add(test2);
		testList.add(test3);
		
		return testList;
    }
    
    public String getAccessToken() throws Exception {    
        MockHttpServletResponse response = mvc
                .perform(post("/oauth/token")
                        .param("username", "user1")
                        .param("password", "user123")
                        .param("client_id", "mert")
                        .param("client_secret", "mertsecret")
                        .param("grant_type", "password"))
                .andExpect(status().isOk())
                .andReturn().getResponse();
        return new ObjectMapper()
                .readValue(response.getContentAsByteArray(), OAuthToken.class)
                .accessToken;
    }
    
    

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class OAuthToken {
        @JsonProperty("access_token")
        public String accessToken;
    }
}