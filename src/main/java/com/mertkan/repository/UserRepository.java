package com.mertkan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mertkan.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT DISTINCT user FROM User user WHERE user.username= :username")
	User findByUsername(@Param("username") String username);
	
}
