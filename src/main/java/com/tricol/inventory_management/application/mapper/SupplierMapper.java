package com.tricol.inventory_management.application.mapper;


import com.tricol.inventory_management.application.dto.request.CreateSupplierRequest;
import com.tricol.inventory_management.application.dto.response.SupplierResponse;
import com.tricol.inventory_management.domain.model.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public interface SupplierMapper {
    Supplier toEntity(CreateSupplierRequest request);
    SupplierResponse toResponse(Supplier supplier);
}

