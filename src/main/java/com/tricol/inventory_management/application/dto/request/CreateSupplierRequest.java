package com.tricol.inventory_management.application.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder




public class CreateSupplierRequest {
    @NotBlank(message = "Company name is required")
    private String name;

    @Email(message = "Email is required")
    private String contactEmail;
    private String phoneNumber;
    private String address;
    private String city;

    @NotBlank(message = "Tax ID is required")
    private String taxId;
    private String contactPerson;

}
