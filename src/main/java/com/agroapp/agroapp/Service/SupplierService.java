package com.agroapp.agroapp.Service;


import com.agroapp.agroapp.Entity.Supplier;
import com.agroapp.agroapp.repository.SupplierRepository;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }
    public Supplier findById(Long id) {
        return supplierRepository.findById(id).orElse(null);
    }
}
