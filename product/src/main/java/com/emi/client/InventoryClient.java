package com.emi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="inventory", url="http://inventory:8080")
public interface InventoryClient {

	@PostMapping("/api/inventory")
	ResponseEntity<String> updateInventory(
			@RequestParam String skuCode,
			@RequestParam Integer quantity
			);
}
