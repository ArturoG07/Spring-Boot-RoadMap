package com.Sring.CRUD_JPA.service;

import com.Sring.CRUD_JPA.model.User;
import java.util.List;

/**
 * Interface for user service operations.
 */
public interface IUserService {

    // Create a user
    public void createUser(User user);

    // Read a user by ID
    public User getUserById(Long id);

    // Update  a user's details
    public void updateUser(Long originalId, String newName, String newEmail, Integer newAge);

    // Delete a user by ID
    public void deleteUser(Long id);



}