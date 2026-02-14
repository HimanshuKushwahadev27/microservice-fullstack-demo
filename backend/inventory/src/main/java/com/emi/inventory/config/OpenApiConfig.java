package com.emi.inventory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

	
	@Bean
	OpenAPI openApiCOnfiguration() {
		return new OpenAPI()
				.info(new Info()
						.title("Inventory Service API")
						.description("API documentation for Inventory Service")
						.version("1.0")
						.license(
			     			 new License()
						    .name("Apache 2.0")
						    .url("http://springdoc.org")
						))
				.externalDocs(new ExternalDocumentation()
						.description("Inventory Service Wiki Documentation")
						.url("https://inventory-demo.com/docs")
				);
		
	}
}
