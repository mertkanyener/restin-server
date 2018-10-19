package com.mertkan.web;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mertkan.model.Role;
import com.mertkan.model.User;
import com.mertkan.repository.RoleRepository;
import com.mertkan.service.UserService;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserService userService;	
	
	@PostMapping(path = "/register")
	public void create(@RequestBody User user) {
		Set<Role> roles = new HashSet<Role>();
		roles.add(roleRepository.findRoleById(2l));
		user.setRoles(roles);
		this.userService.save(user);
	}
	
	

}
