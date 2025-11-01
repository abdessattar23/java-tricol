package com.tricol.inventory_management.application.dto.request;
import jakarta.validation.constraints.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {
    @NotNull(message = "Supplier ID cannot be null")
    private Long supplierId;
    @NotNull(message = "Total amount cannot be null")
    @Positive(message = "Total amount must be positive")
    private Double totalAmount;
}

// public record CreateOrderRequest(
//         @NotNull(message = "Supplier ID cannot be null")
//         Long supplierId,

//         @NotNull(message = "Total amount cannot be null")
//         @Positive(message = "Total amount must be positive")
//         Double totalAmount
// ) {}
