package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {	
	
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		
		UserDetails admin = User.withUsername("Siraj")
			.password(encoder.encode("abc123"))
			.roles("ADMIN")
			.build();
		
		UserDetails user = User.withUsername("Rupesh")
			.password(encoder.encode("rupa123"))
			.roles("USER")
			.build();
		
		return new InMemoryUserDetailsManager(admin,user);
		
	}
	
	
	public SecurityFilterChain securityFilterChain(HttpSecurity https) throws Exception {
		
		return https.csrf()
					.disable()
					.authorizeHttpRequests()
					.requestMatchers("/employee/save").permitAll()
					.and()
					.authorizeHttpRequests()
					.requestMatchers("/employee/**")
					.authenticated().and().formLogin().and().build();
	}
	
	
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		
		return new BCryptPasswordEncoder();
	}

}
