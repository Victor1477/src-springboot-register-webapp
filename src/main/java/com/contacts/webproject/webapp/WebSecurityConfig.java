package com.contacts.webproject.webapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.builder()
				.username("victor")
				.password("{bcrypt}$2a$13$qDELBBv8OdAwGwB7XFVYKOIL1spmPN7hGRQrZ5w5d9psFrUlFvcDa")
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(user);
	}
}