package com.mertkan;

import java.security.Principal;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@Configuration
@RestController
public class ClientApp {
	
	@RequestMapping("/")
	public String home(Principal user) {
		return "Hello " + user.getName();
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(ClientApp.class).properties("spring.config.name=client").run(args);

	}

}
