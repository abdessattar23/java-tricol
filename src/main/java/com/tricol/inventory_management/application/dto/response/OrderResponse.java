package com.tricol.inventory_management.application.dto.response;
import lombok.*;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {
    private Long id;
    private LocalDateTime orderDate;
    private String status;
    private Long supplierId;
    private String supplierName;
    private BigDecimal totalAmount;
    private LocalDateTime receptionDate;
    private List<OrderLineResponse> orderLines;
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class OrderLineResponse {
        private Long id;
        private Long productId;
        private String productName;
        private Integer quantity;
        private BigDecimal unitPrice;
        private BigDecimal totalPrice;
    }
}

