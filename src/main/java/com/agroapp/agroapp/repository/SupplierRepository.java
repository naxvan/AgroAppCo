package com.agroapp.agroapp.repository;

import com.agroapp.agroapp.Entity.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Long> {

}
