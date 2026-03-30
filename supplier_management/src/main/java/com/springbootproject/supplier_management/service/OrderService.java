package com.springbootproject.supplier_management.service;

import com.springbootproject.supplier_management.model.Order;
import com.springbootproject.supplier_management.model.OrderItem;
import com.springbootproject.supplier_management.model.Product;
import com.springbootproject.supplier_management.repository.OrderRepository;
import com.springbootproject.supplier_management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    // Place a new order
    public Order placeOrder(Order order) {
        BigDecimal totalAmount = BigDecimal.ZERO;

        // Loop through each item in the order
        for (OrderItem item : order.getOrderItems()) {
            Product product = productRepository.findById(item.getProduct().getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            // Check stock
            if (product.getStockQuantity() < item.getQuantity()) {
                throw new RuntimeException("Not enough stock for product: " + product.getProductName());
            }

            // Deduct stock
            product.setStockQuantity(product.getStockQuantity() - item.getQuantity());
            productRepository.save(product);

            // Calculate item price (unit price × quantity)
            BigDecimal itemPrice = product.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
            item.setPrice(itemPrice);
            item.setOrder(order); // link back to order

            // Add to total
            totalAmount = totalAmount.add(itemPrice);
        }

        // Set total amount and order date
        order.setTotalAmount(totalAmount);
        order.setOrderDate(java.time.LocalDate.now());

        // Save the order (with items)
        return orderRepository.save(order);
    }

    // Get all orders
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    // Get order by ID
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    // Update order status
    public Order updateOrderStatus(Long id, String status) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setOrderStatus(status);
        return orderRepository.save(order);
    }

    // Delete order
    public String deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            return "Order not found.";
        }
        orderRepository.deleteById(id);
        return "Order with ID " + id + " deleted.";
    }
}
