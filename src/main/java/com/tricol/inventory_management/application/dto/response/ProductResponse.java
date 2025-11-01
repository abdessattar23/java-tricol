package com.tricol.inventory_management.application.dto.response;

import lombok.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private Long id;
    private String name;
    private String reference;
    private String description;
    private BigDecimal unitPrice;
    private Integer stockQuantity;
    private String category;
    private Integer reorderLevel;
    private String unitOfMeasure;
    private Long supplierId;
    private String createdAt;
}
