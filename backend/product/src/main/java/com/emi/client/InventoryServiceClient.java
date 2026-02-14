package com.emi.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class InventoryServiceClient  {


	private final InventoryClient client;
	
	@CircuitBreaker(
		name = "inventory",
		fallbackMethod = "inventoryFallback"
	)
	public ResponseEntity<String> updateInventory(String skuCode, Integer quantity) {
		return client.updateInventory(skuCode, quantity);
	}
	
	public ResponseEntity<String> inventoryFallback(
			String sku,
			Integer qty,
			Throwable ex
	) {
		log.error(
			"INVENTORY SERVICE DOWN | sku={} qty={} | cause={}",
			sku, qty, ex.toString()
		);
		return ResponseEntity.status(503).body("Inventory service is currently unavailable. Please try again later.");
	}

}
