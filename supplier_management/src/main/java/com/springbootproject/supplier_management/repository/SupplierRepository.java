package com.springbootproject.supplier_management.repository;

import com.springbootproject.supplier_management.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}


