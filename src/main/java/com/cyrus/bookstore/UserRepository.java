package com.cyrus.bookstore;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cyrus.bookstore.model.User;


public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User>  findByUsername(String email);
}
