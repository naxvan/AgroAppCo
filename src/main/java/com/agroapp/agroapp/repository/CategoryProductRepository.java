package com.agroapp.agroapp.repository;

import com.agroapp.agroapp.Entity.ProductCategory;
import org.springframework.data.repository.CrudRepository;

public interface CategoryProductRepository extends CrudRepository<ProductCategory, Long> {
}
