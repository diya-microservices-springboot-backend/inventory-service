package com.diya.microservices.inventory.service;

import com.diya.microservices.inventory.dto.InventoryRequest;
import org.springframework.http.ResponseEntity;

public interface InventoryService {
    ResponseEntity<Object> addInventory(InventoryRequest inventoryRequest) throws Exception;

    ResponseEntity<Object> getInventoryBySkuCode(String skuCode) throws Exception;

    ResponseEntity<Object> getInventoryByQuantity(Integer quantity) throws Exception;

    ResponseEntity<Object> getAllInventory() throws Exception;

    ResponseEntity<Object> updateInventory(Long id, Integer quantity) throws Exception;

    ResponseEntity<Object> isInStock(String skuCode, Integer quantity) throws Exception;
}
