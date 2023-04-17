package com.contacts.webproject.webapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests((authorize) -> authorize
						.anyRequest().authenticated())
				.formLogin(form -> form
						.loginPage("/login")
						.permitAll())
				.logout(logout -> logout
						.logoutUrl("/logout")
						.invalidateHttpSession(true)
						.deleteCookies());
		return http.build();
	}
}