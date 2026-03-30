package com.springbootproject.supplier_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.supplier_management.model.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

}