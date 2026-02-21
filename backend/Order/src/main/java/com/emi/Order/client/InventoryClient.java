package com.emi.Order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "inventory",
             url = "${services.inventory.url}"
              )
public interface InventoryClient {

	@GetMapping("/api/inventory")
	boolean checkInventory(@RequestParam("skuCode") String skuCode , @RequestParam Integer quantity);
}
