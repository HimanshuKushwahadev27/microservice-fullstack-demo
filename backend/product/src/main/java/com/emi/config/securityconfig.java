package com.emi.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;

@Configuration
public class securityconfig {

	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {
	    http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
    return http.build();
	}
	
	@Bean
	ObservedAspect observedAspect(ObservationRegistry registry) {
		return new ObservedAspect(registry);
	}
}
