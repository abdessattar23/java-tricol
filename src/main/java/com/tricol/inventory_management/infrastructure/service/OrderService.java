package com.tricol.inventory_management.infrastructure.service;

import com.tricol.inventory_management.application.dto.request.CreateOrderRequest;
import com.tricol.inventory_management.application.dto.response.OrderResponse;
import java.util.List;

public interface OrderService {
    OrderResponse create(CreateOrderRequest request);
    OrderResponse getById(Long id);
    List<OrderResponse> getAll();
    OrderResponse update(Long id, CreateOrderRequest request);
    void delete(Long id);
}
