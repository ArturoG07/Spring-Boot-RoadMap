package com.Sring.CRUD_JPA.service;

import com.Sring.CRUD_JPA.model.User;
import com.Sring.CRUD_JPA.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for user operations, implementing the IUserService interface for a complete CRUD functionality.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    //Create
    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    //Read
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    //Update
    @Override
    public void updateUser(Long originalId, String newName, String newEmail, Integer newAge) {
        User user = userRepository.findById(originalId)
                .orElseThrow(() -> new RuntimeException("User not found with id " + originalId));

        if (newName != null)  user.setName(newName);
        if (newEmail != null) user.setEmail(newEmail);
        if (newAge != null)   user.setAge(newAge);

        userRepository.save(user);
    }

    //Delete
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
