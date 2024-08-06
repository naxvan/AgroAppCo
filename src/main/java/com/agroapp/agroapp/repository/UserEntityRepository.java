package com.agroapp.agroapp.repository;

import com.agroapp.agroapp.Entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface UserEntityRepository extends CrudRepository<Customer, Long> {
}
