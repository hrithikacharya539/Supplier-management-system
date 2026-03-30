package com.springbootproject.supplier_management.controller;

import com.springbootproject.supplier_management.model.Delivery;
import com.springbootproject.supplier_management.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping
    public Delivery addDelivery(@RequestBody Delivery delivery) {
        return deliveryService.addDelivery(delivery);
    }

    @GetMapping
    public List<Delivery> getDeliveries() {
        return deliveryService.getDeliveries();
    }

    @GetMapping("/{id}")
    public Delivery getDeliveryById(@PathVariable Long id) {
        return deliveryService.getDeliveryById(id);
    }

    @PutMapping("/{id}/status")
    public Delivery updateDeliveryStatus(@PathVariable Long id, @RequestParam String status) {
        return deliveryService.updateDeliveryStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public String deleteDelivery(@PathVariable Long id) {
        return deliveryService.deleteDelivery(id);
    }
}
