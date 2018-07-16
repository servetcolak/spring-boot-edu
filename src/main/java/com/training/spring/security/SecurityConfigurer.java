package com.training.spring.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer {

	private static final Logger logger = LoggerFactory.getLogger(SecurityConfigurer.class);

	@Bean
	public BCryptPasswordEncoder createPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService createUserDetailsService() {
		return new MyUserDetails();
	}

	@Autowired
	public void initSecurity(AuthenticationManagerBuilder managerBuilder) {
		try {
			BCryptPasswordEncoder enc = createPasswordEncoder();
			UserDetailsService userDetailsService = createUserDetailsService();
			managerBuilder.userDetailsService(userDetailsService).passwordEncoder(enc);
			// managerBuilder.inMemoryAuthentication().passwordEncoder(enc).withUser("servet").password(enc.encode("1234"))
			// .roles("ADMIN").and().withUser("ahmet").password(enc.encode("1234")).roles("USER");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
