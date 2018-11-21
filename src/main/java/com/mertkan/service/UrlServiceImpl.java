package com.mertkan.service;


import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mertkan.model.URL;
import com.mertkan.repository.UrlRepository;

@Service
public class UrlServiceImpl implements UrlService {
	
	@Autowired
	private UrlRepository urlRepository;
	
	@Override
	public void save(URL url) {
		urlRepository.save(url);
	}

	@Override
	public URL findByUrlId(Long id) {
		return urlRepository.findByUrlId(id);
	}
	
	@Override
	public List<URL> findByProjectId(Long projectId) {
		List<URL> urls = urlRepository.findByProjectId(projectId);
		urls.sort(Comparator.comparing(URL:: getId));
		return urls; 
	}

	@Override
	public void delete(Long id) {
		urlRepository.deleteById(id);
	}

	@Override
	public void update(URL url) {
		urlRepository.save(url);	
	}
	
	@Override
	public Long getMaxId() {
		return urlRepository.maxId();
	}
	
	@Override
	public URL getUrl(Long projectId, String path, int code, String method) {
		return urlRepository.getUrl(projectId, path, code, method);
	}


}
