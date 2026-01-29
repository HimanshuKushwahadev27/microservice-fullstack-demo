package com.emi.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emi.inventory.entity.Inventory;

public interface InventoryRepo extends JpaRepository<Inventory , Long> {

	boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantity);

	boolean existsBySkuCode(String skuCode);

	Inventory findBySkuCode(String skuCode);
}
