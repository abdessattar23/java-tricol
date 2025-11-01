package com.tricol.inventory_management.application.dto.response;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockDetailsResponse {
    private Long productId;
    private String productName;
    private String productReference;
    private Integer totalQuantity;
    private Integer reorderLevel;
    private boolean belowReorderLevel;
    private List<BatchInfo> batches;
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class BatchInfo {
        private Long batchId;
        private Integer remainingQuantity;
        private String entryDate;
        private String purchaseUnitPrice;
    }
}
