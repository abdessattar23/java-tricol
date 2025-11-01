package com.tricol.inventory_management.application.mapper;

import com.tricol.inventory_management.application.dto.request.CreateOrderRequest;
import com.tricol.inventory_management.application.dto.response.OrderResponse;
import com.tricol.inventory_management.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order toEntity(CreateOrderRequest request);
    OrderResponse toResponse(Order order);
}

