package com.tricol.inventory_management.application.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateDeliveryNoteRequest {
    @NotBlank(message = "Workshop is required")
    private String workshop;
    
    @NotBlank(message = "Reason is required")
    private String reason;
    
    private String notes;
    
    @NotEmpty(message = "Delivery note lines cannot be empty")
    private List<DeliveryNoteLineRequest> lines;
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DeliveryNoteLineRequest {
        @NotNull(message = "Product ID is required")
        private Long productId;
        
        @NotNull(message = "Quantity is required")
        @Positive(message = "Quantity must be positive")
        private Integer quantity;
    }
}
