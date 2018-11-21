package com.mertkan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mertkan.config.encryption.Encoder;
import com.mertkan.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@Order(100)
@Import(Encoder.class)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new UserDetailsServiceImpl();
    }
	
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	public void configure (AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsServiceBean())
			.passwordEncoder(passwordEncoder);
	}
	
	/*
	
	@Bean
	public ObjectPostProcessor<Object> objectPostProcessor() throws Exception {
		return objectPostProcessor();		
	}
	*/
	
	
	/**
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/admin/**", "/register**");
	}
	**/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/register").permitAll()
			.antMatchers("/oauth/token").permitAll()
			.antMatchers("/oauth/revoke-token").permitAll()
			.antMatchers("/validation/**").permitAll()
			.anyRequest().authenticated();
			
	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.antMatcher("/**")
//			.authorizeRequests()
//				.antMatchers("/**")
//				.permitAll();
//	}
//
//	

	
}
