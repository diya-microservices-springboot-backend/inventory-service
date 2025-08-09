package com.diya.microservices.inventory.service.impl;

import com.diya.microservices.inventory.dto.InventoryRequest;
import com.diya.microservices.inventory.dto.ResponseHandler;
import com.diya.microservices.inventory.model.Inventory;
import com.diya.microservices.inventory.repository.InventoryRepository;
import com.diya.microservices.inventory.service.InventoryService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
        try {
            boolean isAvailable = inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);

            ResponseHandler response = new ResponseHandler();
            if (isAvailable) {
                response.setResponseCode(HttpStatus.OK.toString());
                response.setResponse("success");
            } else {
                response.setResponseCode(HttpStatus.BAD_REQUEST.toString());
                response.setResponse("Product not available");
            }
            log.info(response.getResponse());
            return ResponseEntity.status(200).body(response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public ResponseEntity<Object> removeInventory(String skuCode) throws Exception {
        log.info("Removing inventory");
        inventoryRepository.removeInventoryBySkuCode(skuCode);
        return ResponseEntity.status(200).body("Inventory removed");
    }
}

