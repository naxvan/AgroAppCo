package com.agroapp.agroapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.agroapp.agroapp.Entity.User;

public interface UserRepository extends CrudRepository<User,Long>{
    User findByEmail(String email);
}
