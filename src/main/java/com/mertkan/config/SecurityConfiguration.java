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

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().sameOrigin();
		http
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/**").permitAll()
			.anyRequest().authenticated();
			
	}


	
}
