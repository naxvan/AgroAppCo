package com.agroapp.agroapp.Service;


import com.agroapp.agroapp.Entity.Product;
import com.agroapp.agroapp.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }
}