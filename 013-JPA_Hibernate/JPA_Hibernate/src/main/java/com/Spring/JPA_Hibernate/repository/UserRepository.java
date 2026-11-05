package com.Spring.JPA_Hibernate.repository;

import com.Spring.JPA_Hibernate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for User entity. This interface extends JpaRepository to provide CRUD operations and custom queries for the Persona entity.
 */
@Repository //maps as repository
//Parameters are the entity class and the type of its primary key
public interface UserRepository extends JpaRepository<User, Long> {

}
