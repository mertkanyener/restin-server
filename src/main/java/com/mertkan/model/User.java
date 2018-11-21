package com.mertkan.model;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "User_")
public class User implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
	@SequenceGenerator(sequenceName = "user_seq", initialValue = 2, allocationSize = 2, name = "USER_SEQ" )
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	@Column(name = "password", nullable = false)
	private String password;
	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name= "user_role", joinColumns = 
	@JoinColumn(name = "user_id"), inverseJoinColumns = 
	@JoinColumn(name = "role_id"))
	private Set<Role> roles;	
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String extractPassword() {
		return password;
	}
	
	public String getPassword() {
		 return password;
	}
	public void setPassword(String password) {
		 this.password = password;
	} 
	public String toString() {
		return "User Id: " + this.id + "\n User e-mail: " + this.email + "\n Username: " + this.username;
	}
	/**
	private Collection<? extends GrantedAuthority> translate(List<Role> roles) { 
		List<GrantedAuthority> authorities = new ArrayList<>(); 
		for (Role role : roles) { 
			String name = role.getRole().toUpperCase(); 
			if (!name.startsWith("ROLE_")) { 
				name = "ROLE_" + name; 
			} 
			authorities.add(new SimpleGrantedAuthority(name)); 
		} 
		return authorities; 
	} 
	**/
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getRoles()
			.stream()
			.map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole()))
			.collect(Collectors.toList());
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}	
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
