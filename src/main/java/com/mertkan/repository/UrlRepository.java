package com.mertkan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mertkan.model.URL;

@Repository
public interface UrlRepository extends JpaRepository<URL, Long> {
	
	@Query("SELECT DISTINCT url FROM URL url WHERE url.id= :id")
	URL findByUrlId(@Param("id") Long id);
	@Query("SELECT DISTINCT url FROM URL url WHERE url.projectId= :projectId")
	List<URL> findByProjectId(@Param("projectId") Long projectId);
	@Query("SELECT max(url.id) FROM URL url")
	Long maxId();
	@Query("SELECT url FROM URL url WHERE url.projectId= :projectId AND url.path= :path AND url.responseCode = :code AND url.method= :method")
	URL getUrl(@Param("projectId") Long projectId, @Param("path") String path, @Param("code") int code, @Param("method") String method);
	

}
