package com.tricol.inventory_management.domain.model;

import com.tricol.inventory_management.domain.enums.DeliveryNoteStatus;
import com.tricol.inventory_management.domain.enums.DeliveryReason;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "delivery_notes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "note_number", unique = true, nullable = false)
    private String noteNumber;

    @Column(name = "workshop")
    private String workshop;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private DeliveryNoteStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "reason", nullable = false)
    private DeliveryReason reason;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "validated_date")
    private LocalDateTime validatedDate;

    @Column(name = "notes")
    private String notes;

    @OneToMany(mappedBy = "deliveryNote", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DeliveryNoteLine> deliveryNoteLines;
}
