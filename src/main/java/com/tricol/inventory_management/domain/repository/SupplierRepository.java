package com.tricol.inventory_management.domain.repository;

import com.tricol.inventory_management.domain.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Optional<Supplier> findByContactEmail(String contactEmail);
    Optional<Supplier> findByTaxId(String taxId);
    boolean existsByContactEmail(String contactEmail);
    boolean existsByTaxId(String taxId);
}
