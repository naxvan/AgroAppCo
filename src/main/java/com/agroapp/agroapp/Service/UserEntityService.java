package com.agroapp.agroapp.Service;

import com.agroapp.agroapp.Entity.Customer;
import com.agroapp.agroapp.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService {
    private final UserEntityRepository userEntityRepository;

    public UserEntityService(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }
    public Customer findById(Long id) {
        return userEntityRepository.findById(id).orElse(null);
    }
}
