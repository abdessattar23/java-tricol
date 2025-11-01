package com.tricol.inventory_management.infrastructure.service;

import com.tricol.inventory_management.application.dto.request.CreateSupplierRequest;
import com.tricol.inventory_management.application.dto.response.SupplierResponse;
import java.util.List;

public interface SupplierService {
    SupplierResponse create(CreateSupplierRequest request);
    SupplierResponse getById(Long id);
    List<SupplierResponse> getAll();
    SupplierResponse update(Long id, CreateSupplierRequest request);
    void delete(Long id);
}
