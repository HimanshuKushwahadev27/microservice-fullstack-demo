package com.emi.microservices.product;

import org.springframework.boot.SpringApplication;

import com.emi.ProductApplication;

public class TestProductApplication {

	public static void main(String[] args) {
		SpringApplication.from(ProductApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
