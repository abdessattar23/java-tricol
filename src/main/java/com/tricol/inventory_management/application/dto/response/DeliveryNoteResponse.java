package com.tricol.inventory_management.application.dto.response;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryNoteResponse {
    private Long id;
    private String noteNumber;
    private String workshop;
    private String status;
    private String reason;
    private String createdDate;
    private String validatedDate;
    private String notes;
    private List<DeliveryNoteLineResponse> lines;
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class DeliveryNoteLineResponse {
        private Long id;
        private Long productId;
        private String productName;
        private Integer quantity;
    }
}
