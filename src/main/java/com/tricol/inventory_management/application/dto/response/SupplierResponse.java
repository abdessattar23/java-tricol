package com.tricol.inventory_management.application.dto.response;

import lombok.*;

@Data
@NoArgsConstructor

@AllArgsConstructor
@Builder
public class SupplierResponse {
    private Long id;
    private String name;
    private String contactEmail;
    private String phoneNumber;
    private String address;
    private String city;
    private String taxId;
    private String contactPerson;
    private String createdAt;
}
