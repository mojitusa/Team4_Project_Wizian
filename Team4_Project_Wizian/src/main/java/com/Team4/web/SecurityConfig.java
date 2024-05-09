package com.Team4.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public BCryptPasswordEncoder bCrryptpasswordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
			.authorizeRequests((auth) -> auth
					.requestMatchers("/", "/login","/loginProc","/signUp", "/signUpProc").permitAll()
					//.requestMatchers("/admin").hasRole("ADMIN")
					//.requestMatchers("/templates/**").hasAnyRole("ADMIN","USER")
					.anyRequest().authenticated());
//		http
//			.formLogin((auth) -> auth.loginPage("/login")
//					.loginProcessingUrl("/loginProc")
//					.permitAll()
//					);
		http
		.formLogin((auth) -> auth.loginPage("/signUp")
				.loginProcessingUrl("/signUpProc")
				.permitAll()
				);
		http
			.csrf((auth) -> auth.disable()
					);
		
		
		return http.build();
	}
}