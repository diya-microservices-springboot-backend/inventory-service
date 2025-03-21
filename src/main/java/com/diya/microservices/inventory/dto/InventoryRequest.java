package com.diya.microservices.inventory.dto;
import jakarta.validation.constraints.NotNull;

public record InventoryRequest(
        @NotNull(message = "Sku Code is mandatory!")
        String skuCode,
        @NotNull(message = "Quantity is mandatory!")
        Integer quantity
) {
}