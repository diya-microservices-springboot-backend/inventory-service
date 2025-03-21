package com.diya.microservices.inventory.service.impl;

import com.diya.microservices.inventory.dto.InventoryRequest;
import com.diya.microservices.inventory.model.Inventory;
import com.diya.microservices.inventory.repository.InventoryRepository;
import com.diya.microservices.inventory.service.InventoryService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService {
    private InventoryRepository inventoryRepository;

    @Override
    public ResponseEntity<Object> addInventory(InventoryRequest inventoryRequest) throws Exception {
        Inventory inventory = new Inventory();
        inventory.setSkuCode(inventoryRequest.skuCode());
        inventory.setQuantity(inventoryRequest.quantity());
        inventoryRepository.save(inventory);

        return ResponseEntity.status(201).body(inventory);
    }

    @Override
    public ResponseEntity<Object> getInventoryBySkuCode(String skuCode) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Object> getInventoryByQuantity(Integer quantity) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Object> getAllInventory() throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Object> updateInventory(Long id, Integer quantity) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Object> isInStock(String skuCode, Integer quantity) throws Exception {
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity)
                ? ResponseEntity.status(200).body("In stock")
                : ResponseEntity.status(422).body("Out of stock");
    }
}
