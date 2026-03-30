package com.springbootproject.supplier_management.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryId;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private String deliveryStatus;
    private LocalDate dispatchDate;
    private LocalDate deliveryDate;

    // Constructors
    public Delivery() {}

    public Delivery(Order order, String deliveryStatus, LocalDate dispatchDate, LocalDate deliveryDate) {
        this.order = order;
        this.deliveryStatus = deliveryStatus;
        this.dispatchDate = dispatchDate;
        this.deliveryDate = deliveryDate;
    }

    // Getters and Setters
    public Long getDeliveryId() { return deliveryId; }
    public void setDeliveryId(Long deliveryId) { this.deliveryId = deliveryId; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }

    public String getDeliveryStatus() { return deliveryStatus; }
    public void setDeliveryStatus(String deliveryStatus) { this.deliveryStatus = deliveryStatus; }

    public LocalDate getDispatchDate() { return dispatchDate; }
    public void setDispatchDate(LocalDate dispatchDate) { this.dispatchDate = dispatchDate; }

    public LocalDate getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(LocalDate deliveryDate) { this.deliveryDate = deliveryDate; }
}
