package com.agroapp.agroapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.agroapp.agroapp.Entity.Role;
import com.agroapp.agroapp.Entity.RoleEnum;

public interface RoleRepository extends CrudRepository<Role, Long>{
    Role findByRoleEnum(RoleEnum name);
}
