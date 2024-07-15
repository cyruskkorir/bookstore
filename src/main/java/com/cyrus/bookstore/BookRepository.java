package com.cyrus.bookstore;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cyrus.bookstore.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
    
}
