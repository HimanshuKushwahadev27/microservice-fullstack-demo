package com.emi.inventory.service;

import org.springframework.stereotype.Service;

import com.emi.inventory.entity.Inventory;
import com.emi.inventory.repository.InventoryRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

	private final InventoryRepo repo;
	
	public boolean isInStock(String skuCode ,Integer quantity) {
		return repo.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode,quantity);
	}

	public  String updateInventory(String skuCode, Integer quantity) {
		
		if(repo.existsBySkuCode(skuCode)) {
			Inventory inv=repo.findBySkuCode(skuCode);
			inv.setQuantity(quantity);
			repo.save(inv);
			return "Inventory updated";
		}else {
			var inv=Inventory.builder().quantity(quantity).skuCode(skuCode).build();
			repo.save(inv);
			return "Inventory created";
		}
		
	}
}
