package com.emi.order;

import org.springframework.boot.SpringApplication;
import  com.emi.order.TestcontainersConfiguration;


public class TestOrderApplication {

	public static void main(String[] args) {
		SpringApplication.from(OrderApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
