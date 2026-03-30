package com.springbootproject.supplier_management.service;

import com.springbootproject.supplier_management.model.Product;
import com.springbootproject.supplier_management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public String deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            return "Product not found.";
        }
        productRepository.deleteById(id);
        return "Product with ID " + id + " deleted.";
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
}
