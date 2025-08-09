package com.diya.microservices.inventory.repository;

import com.diya.microservices.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantityIsGreaterThan);

//    @Modifying
//    @Query("DELETE FROM Inventory i WHERE i.skuCode = :skuCode")
//    void removeInventoryBySkuCode(String skuCode);

    void removeInventoryBySkuCode(String skuCode);

}
