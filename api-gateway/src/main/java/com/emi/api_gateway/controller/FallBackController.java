package com.emi.api_gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

	@GetMapping("/fallback/product")
	public ResponseEntity<String> productServiceFallBack() {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
				.body("Product Service is currently unavailable. Please try again later.");
	}
	
	@GetMapping("/fallback/order")
	public ResponseEntity<String> orderServiceFallBack() {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
				.body("order Service is currently unavailable. Please try again later.");
	}
	
	@GetMapping("/fallback/inventory")
	public ResponseEntity<String> inventoryServiceFallBack() {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
				.body("Inventory Service is currently unavailable. Please try again later.");
	}
	
	
}
