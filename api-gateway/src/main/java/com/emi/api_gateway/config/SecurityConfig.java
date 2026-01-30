package com.emi.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

    	 return http
    		        .authorizeExchange(ex -> ex.anyExchange().authenticated())
    		        .oauth2ResourceServer(o -> o.jwt(Customizer.withDefaults()))
    		        .build();
    }
}
