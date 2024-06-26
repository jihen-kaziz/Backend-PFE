package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration 
{
	private static final String[] WHITE_LIST_URL =
		{
				"/api/auth/**",
				"/api/AccountsManagement/**",
				"/api/jobs/**",
				"/api/jobApplications/**",
				"/api/specialities/**"
		};
	private final JwtAuthenticationFilter jwtAuthFilter;
	private final AuthenticationProvider authenticationProvider;
	
	@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
		http	
			.cors(withDefaults())
			.csrf(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests(req ->
				req.requestMatchers(WHITE_LIST_URL)
					.permitAll()
					.anyRequest()
					.authenticated()
			)
			.sessionManagement(session -> session.sessionCreationPolicy(STATELESS))		
			.authenticationProvider(authenticationProvider)
			.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)	
		;
		return http.build();
    }
}
