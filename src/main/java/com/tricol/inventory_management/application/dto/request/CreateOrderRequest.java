package com.tricol.inventory_management.application.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrderRequest {
    @NotNull(message = "Supplier ID cannot be null")
    private Long supplierId;

    @NotEmpty(message = "Order lines cannot be empty")
    private List<OrderLineRequest> orderLines;
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderLineRequest {
        @NotNull(message = "Product ID is required")
        private Long productId;
        
        @NotNull(message = "Quantity is required")
        @Positive(message = "Quantity must be positive")
        private Integer quantity;
        
        @NotNull(message = "Unit price is required")
        @Positive(message = "Unit price must be positive")
        private BigDecimal unitPrice;
    }
}
