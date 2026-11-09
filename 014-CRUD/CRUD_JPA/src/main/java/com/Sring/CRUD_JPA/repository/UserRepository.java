package com.Sring.CRUD_JPA.repository;

import com.Sring.CRUD_JPA.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
