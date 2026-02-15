package com.emi.Order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "inventory",
             url = "http://inventory:8080"
              )
public interface InventoryClient {

	@GetMapping("/api/inventory")
	boolean checkInventory(@RequestParam String skuCode , @RequestParam Integer quantity);
}
