package com.agroapp.agroapp.Service;


import com.agroapp.agroapp.Entity.ProductCategory;
import com.agroapp.agroapp.repository.CategoryProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryProducService {
    private final CategoryProductRepository categoryProductRepository;

    public CategoryProducService(CategoryProductRepository categoryProductRepository) {
        this.categoryProductRepository = categoryProductRepository;
    }

    public Iterable<ProductCategory> getAllCategories() {
          return categoryProductRepository.findAll();
    }

}
