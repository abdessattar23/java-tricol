package com.tricol.inventory_management.application.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProductRequest {
    @NotBlank(message = "Product name is required")
    private String name;
    
    @NotBlank(message = "Reference is required")
    private String reference;
    
    private String description;
    
    @NotNull(message = "Unit price is required")
    @Positive(message = "Unit price must be positive")
    private BigDecimal unitPrice;
    
    private String category;
    
    @NotNull(message = "Reorder level is required")
    @PositiveOrZero(message = "Reorder level must be zero or positive")
    private Integer reorderLevel;
    
    @NotBlank(message = "Unit of measure is required")
    private String unitOfMeasure;
    
    private Long supplierId;
}
