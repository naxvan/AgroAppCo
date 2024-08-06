package com.agroapp.agroapp.repository;

import com.agroapp.agroapp.Entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
  public List<Product> findBySupplierId(Long id);

}
