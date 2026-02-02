package com.emi.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class InventoryClientFallback implements InventoryClient {

	@Override
	public ResponseEntity<String> updateInventory(String skuCode, Integer quantity) {
	     return ResponseEntity.status(503)
	             .body("Inventory service is not reachable for " + skuCode);
	}

}
