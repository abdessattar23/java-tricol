package com.tricol.inventory_management.application.dto.response;
import lombok.*;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {
    private Long id;
    private String orderNumber;
    private LocalDateTime orderDate;
    private String status;
    private Long supplierId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

