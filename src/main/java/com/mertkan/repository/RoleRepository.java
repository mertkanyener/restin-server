package com.mertkan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mertkan.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	@Query("SELECT DISTINCT role FROM Role role where role.id= :id")
	Role findRoleById(@Param("id") Long id);

}
