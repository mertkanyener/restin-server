package com.mertkan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
@Import(SecurityConfiguration.class)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{
	


	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.anonymous().disable()
		.requestMatchers().antMatchers("/resources/**")
		.and().authorizeRequests()
		.antMatchers("/resources/**").access("hasRole('ADMIN') or hasRole('USER')")
		.and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}
}
