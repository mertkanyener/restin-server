package com.mertkan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mertkan.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT DISTINCT user FROM User user WHERE user.username= :username")
	User findByUsername(@Param("username") String username);
	@Query("SELECT DISTINCT user FROM User user WHERE user.email= :email")
	User findByEmail(@Param("email") String email);
}
