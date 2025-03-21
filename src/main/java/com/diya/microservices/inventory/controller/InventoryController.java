package com.diya.microservices.inventory.controller;

import com.diya.microservices.inventory.dto.InventoryRequest;
import com.diya.microservices.inventory.model.Inventory;
import com.diya.microservices.inventory.service.InventoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> isInStock(@RequestParam String skuCode, @RequestParam Integer quantity) throws Exception {
        log.info("isInStock skuCode: {}, quantity: {}", skuCode, quantity);
        return inventoryService.isInStock(skuCode, quantity);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> addInventory(@RequestBody @Valid InventoryRequest inventoryRequest) throws Exception {
        log.info("addInventory inventoryRequest: {}", inventoryRequest);
        return inventoryService.addInventory(inventoryRequest);
    }
}
