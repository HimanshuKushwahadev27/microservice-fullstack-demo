package com.emi.Order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

	
	@Bean
	OpenAPI openApiConfiguration() {
		return new OpenAPI()
				.info(
				   new Info().title("Order Service API")
				   .description("API documentation for Order Service")
				   .version("1.0")
				   .license(
					   new License()
					   .name("Apache 2.0")
					   .url("http://springdoc.org")
				   ))
				.externalDocs(
				   new ExternalDocumentation()
				   .description("Order Service Wiki Documentation")
				   .url("https://order-demo.com/docs")
				);
		
	}
	
	
	@Bean
	ObservedAspect observedAspect(ObservationRegistry registry) {
		return new ObservedAspect(registry);
	}
}
