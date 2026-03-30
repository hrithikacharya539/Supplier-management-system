package com.springbootproject.supplier_management.repository;

import com.springbootproject.supplier_management.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
