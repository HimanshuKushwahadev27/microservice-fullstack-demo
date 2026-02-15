package com.emi.Order;

import org.springframework.boot.SpringApplication;

import com.emi.Order.OrderApplication;


public class TestOrderApplication {

	public static void main(String[] args) {
		SpringApplication.from(OrderApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
