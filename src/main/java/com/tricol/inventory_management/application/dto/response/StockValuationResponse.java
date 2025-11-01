package com.tricol.inventory_management.application.dto.response;

import lombok.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockValuationResponse {
    private Long productId;
    private String productName;
    private String productReference;
    private Integer totalQuantity;
    private BigDecimal totalValue;
    private BigDecimal averageUnitCost;
}
