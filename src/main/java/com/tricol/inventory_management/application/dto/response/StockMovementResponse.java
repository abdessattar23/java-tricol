package com.tricol.inventory_management.application.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockMovementResponse {
    private Long id;
    private Long productId;
    private String productName;
    private String movementType;
    private Integer quantity;
    private String movementDate;
    private String reference;
    private String notes;
}
