package com.mertkan.service;

import java.util.List;

import com.mertkan.model.URL;

public interface UrlService {
	
	void save(URL url);
	void delete(Long id);
	void update(URL url);
	URL findByUrlId(Long id);
	List<URL> findByProjectId(Long projectId);
	Long getMaxId();
	String getResponse(Long projectId, String path, Long code, String method);


}
