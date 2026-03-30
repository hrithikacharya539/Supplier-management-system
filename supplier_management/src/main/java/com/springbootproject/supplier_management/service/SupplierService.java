package com.springbootproject.supplier_management.service;

import com.springbootproject.supplier_management.model.Supplier;
import com.springbootproject.supplier_management.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public List<Supplier> getSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(int id) {
        return supplierRepository.findById(id).orElse(null);
    }

    public String deleteSupplier(int id) {
        if (!supplierRepository.existsById(id)) {
            return "Supplier not found.";
        }
        supplierRepository.deleteById(id);
        return "Supplier with ID " + id + " deleted.";
    }
}
