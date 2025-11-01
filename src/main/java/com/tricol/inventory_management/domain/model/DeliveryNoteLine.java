package com.tricol.inventory_management.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "delivery_note_lines")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryNoteLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_note_id", nullable = false)
    private DeliveryNote deliveryNote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}
