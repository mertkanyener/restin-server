package com.mertkan.service;

import com.mertkan.model.User;

public interface UserService {
	
	void save(User user);
	User findByUsername(String username);
	
}
