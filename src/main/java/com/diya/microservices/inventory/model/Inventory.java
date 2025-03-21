package com.diya.microservices.inventory.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "T_INVENTORY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private Integer quantity;
}
