package com.agroapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.agroapp.agroapp.Entity.Role;
import com.agroapp.agroapp.Entity.RoleEnum;
import com.agroapp.agroapp.repository.RoleRepository;

import jakarta.transaction.Transactional;

@Component
public class SetupLoader implements ApplicationListener<ContextRefreshedEvent> {
    
    boolean alreadySetup = false;
        
    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;

        createRoleIfNotFound(RoleEnum.BUYER);
        createRoleIfNotFound(RoleEnum.SELLER);

        alreadySetup = true;
    }

    @Transactional
    Role createRoleIfNotFound(RoleEnum name) {
        Role role = roleRepository.findByRoleEnum(name);
        if (role == null) {
            role = new Role();
            role.setRoleEnum(name);
            roleRepository.save(role);
        }
        return role;
    }
}
