package com.springbootproject.supplier_management.repository;

import com.springbootproject.supplier_management.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
