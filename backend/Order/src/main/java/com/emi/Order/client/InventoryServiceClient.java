package com.emi.Order.client;


import org.springframework.stereotype.Service;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InventoryServiceClient {

    private final InventoryClient inventoryClient;

    public InventoryServiceClient(InventoryClient inventoryClient) {
        this.inventoryClient = inventoryClient;
    }

    @CircuitBreaker(
        name = "inventory",
        fallbackMethod = "inventoryFallback"
    )
    public boolean checkInventory(String skuCode, Integer quantity) {
        return inventoryClient.checkInventory(skuCode, quantity);
        
    }
    
    public boolean inventoryFallback(
            String sku,
            Integer qty,
            Throwable ex
    ) {
        log.error(
            "INVENTORY SERVICE DOWN | sku={} qty={} | cause={}",
            sku, qty, ex.toString()
        );

      return false;
    }
}
