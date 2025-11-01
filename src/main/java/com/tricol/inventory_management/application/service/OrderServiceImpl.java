package com.tricol.inventory_management.application.service;

import com.tricol.inventory_management.application.dto.request.CreateOrderRequest;
import com.tricol.inventory_management.application.dto.response.OrderResponse;
import com.tricol.inventory_management.application.service.OrderService;
import com.tricol.inventory_management.domain.enums.OrderStatus;
import com.tricol.inventory_management.domain.model.Order;
import com.tricol.inventory_management.domain.model.OrderLine;
import com.tricol.inventory_management.domain.model.Product;
import com.tricol.inventory_management.domain.model.Supplier;
import com.tricol.inventory_management.domain.repository.OrderRepository;
import com.tricol.inventory_management.domain.repository.ProductRepository;
import com.tricol.inventory_management.domain.repository.SupplierRepository;
import com.tricol.inventory_management.infrastructure.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    
    private final OrderRepository orderRepository;
    private final SupplierRepository supplierRepository;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public OrderResponse create(CreateOrderRequest request) {
        Supplier supplier = supplierRepository.findById(request.getSupplierId())
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
        
        Order order = new Order();
        order.setSupplier(supplier);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(OrderStatus.PENDING);
        
        List<OrderLine> orderLines = request.getOrderLines().stream().map(lineReq -> {
            Product product = productRepository.findById(lineReq.getProductId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
            
            OrderLine line = new OrderLine();
            line.setOrder(order);
            line.setProduct(product);
            line.setQuantity(lineReq.getQuantity());
            line.setUnitPrice(lineReq.getUnitPrice());
            line.setTotalPrice(lineReq.getUnitPrice().multiply(BigDecimal.valueOf(lineReq.getQuantity())));
            return line;
        }).collect(Collectors.toList());
        
        order.setOrderLines(orderLines);
        order.setTotalAmount(orderLines.stream()
                .map(OrderLine::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add));
        
        Order saved = orderRepository.save(order);
        return toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderResponse getById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
        return toResponse(order);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderResponse> getAll() {
        return orderRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public OrderResponse update(Long id, CreateOrderRequest request) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
        
        Supplier supplier = supplierRepository.findById(request.getSupplierId())
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
        
        order.setSupplier(supplier);
        order.getOrderLines().clear();
        
        List<OrderLine> orderLines = request.getOrderLines().stream().map(lineReq -> {
            Product product = productRepository.findById(lineReq.getProductId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
            
            OrderLine line = new OrderLine();
            line.setOrder(order);
            line.setProduct(product);
            line.setQuantity(lineReq.getQuantity());
            line.setUnitPrice(lineReq.getUnitPrice());
            line.setTotalPrice(lineReq.getUnitPrice().multiply(BigDecimal.valueOf(lineReq.getQuantity())));
            return line;
        }).collect(Collectors.toList());
        
        order.getOrderLines().addAll(orderLines);
        order.setTotalAmount(orderLines.stream()
                .map(OrderLine::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add));
        
        Order updated = orderRepository.save(order);
        return toResponse(updated);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new ResourceNotFoundException("Order not found with id: " + id);
        }
        orderRepository.deleteById(id);
    }
    
    private OrderResponse toResponse(Order order) {
        List<OrderResponse.OrderLineResponse> lineResponses = order.getOrderLines().stream()
                .map(line -> OrderResponse.OrderLineResponse.builder()
                        .id(line.getId())
                        .productId(line.getProduct().getId())
                        .productName(line.getProduct().getName())
                        .quantity(line.getQuantity())
                        .unitPrice(line.getUnitPrice())
                        .totalPrice(line.getTotalPrice())
                        .build())
                .collect(Collectors.toList());
        
        return OrderResponse.builder()
                .id(order.getId())
                .orderDate(order.getOrderDate())
                .status(order.getStatus().name())
                .supplierId(order.getSupplier().getId())
                .supplierName(order.getSupplier().getName())
                .totalAmount(order.getTotalAmount())
                .receptionDate(order.getReceptionDate())
                .orderLines(lineResponses)
                .build();
    }
}
