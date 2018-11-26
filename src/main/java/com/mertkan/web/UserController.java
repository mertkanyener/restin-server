
package com.mertkan.web;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.mertkan.model.Role;
import com.mertkan.model.User;
import com.mertkan.repository.RoleRepository;
import com.mertkan.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenStore tokenStore;
	
	@PostMapping(path = "/register")
	public void create(@RequestBody User user) {
			Set<Role> roles = new HashSet<Role>();
			roles.add(roleRepository.findRoleById(2l));
			user.setRoles(roles);
			this.userService.save(user);

	}
	
	@GetMapping(path = "/oauth/revoke-token")
	public void logout(@RequestHeader(value="Authorization") String token) {
		if (token != null) {
			String tokenValue = token.replace("Bearer", "").trim();
			OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
			tokenStore.removeAccessToken(accessToken);
		}
	}
	
	@GetMapping(path = "/validation/username/{username}")
	public int findUsername(@PathVariable String username) {
		if (userService.findByUsername(username) != null) {
			return 1;
		}else {
			return 0;
		}
	}
	
	@GetMapping(path = "/validation/email/{email}")
	public int findEmail(@PathVariable String email) {
		if (userService.findByEmail(email) != null) {
			return 1;
		}else {
			return 0;
		}
	}

	


}
