package com.diya.microservices.inventory.controller;

import com.diya.microservices.inventory.dto.InventoryRequest;
import com.diya.microservices.inventory.service.InventoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
@CrossOrigin
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<Object> isInStock(@RequestParam String skuCode, @RequestParam Integer quantity) throws Exception {
        return inventoryService.isInStock(skuCode, quantity);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> addInventory(@RequestBody @Valid InventoryRequest inventoryRequest) throws Exception {
        log.info("addInventory inventoryRequest: {}", inventoryRequest);
        return inventoryService.addInventory(inventoryRequest);
    }

    @DeleteMapping("/remove/{skuCode}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> removeInventory(@PathVariable String skuCode) throws Exception {
        log.info("removeInventory skuCode: {}", skuCode);

        return inventoryService.removeInventory(skuCode);
    }
}
