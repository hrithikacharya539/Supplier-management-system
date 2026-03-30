package com.springbootproject.supplier_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.supplier_management.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    
}
