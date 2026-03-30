package com.springbootproject.supplier_management.service;

import com.springbootproject.supplier_management.model.Delivery;
import com.springbootproject.supplier_management.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public Delivery addDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public List<Delivery> getDeliveries() {
        return deliveryRepository.findAll();
    }

    public Delivery getDeliveryById(Long id) {
        return deliveryRepository.findById(id).orElse(null);
    }

    public Delivery updateDeliveryStatus(Long id, String status) {
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delivery not found"));
        delivery.setDeliveryStatus(status);
        return deliveryRepository.save(delivery);
    }

    public String deleteDelivery(Long id) {
        if (!deliveryRepository.existsById(id)) {
            return "Delivery not found.";
        }
        deliveryRepository.deleteById(id);
        return "Delivery with ID " + id + " deleted.";
    }
}
