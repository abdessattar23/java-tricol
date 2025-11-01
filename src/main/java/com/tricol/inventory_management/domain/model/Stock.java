package com.tricol.inventory_management.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "stock_view")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stock {
    @Id
    private Long productId;

    @Column(name = "total_quantity")
    private Integer totalQuantity;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_reference")
    private String productReference;
}
