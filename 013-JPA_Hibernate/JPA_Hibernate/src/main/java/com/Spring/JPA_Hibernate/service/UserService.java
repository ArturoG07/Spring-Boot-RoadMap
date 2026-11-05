package com.Spring.JPA_Hibernate.service;

import com.Spring.JPA_Hibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Service is used to define business logic
@Service
public class UserService {

    // Autowiring the UserRepository to use its methods for database operations
    @Autowired
    private UserRepository userRepository;
}
