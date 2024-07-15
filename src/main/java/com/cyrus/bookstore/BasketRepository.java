package com.cyrus.bookstore;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cyrus.bookstore.model.Basket;

public interface BasketRepository extends JpaRepository<Basket, Long> {
    
}
