package com.Spring.DependenciesInjection.repository;

import com.Spring.DependenciesInjection.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    public List<User> getAll() {

        List<User> usersList = new ArrayList<User>();

        usersList.add(new User("User1", 1));
        usersList.add(new User("User2", 2));

        return usersList;
    }
}
