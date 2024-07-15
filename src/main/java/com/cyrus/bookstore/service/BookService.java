package com.cyrus.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cyrus.bookstore.BookRepository;
import com.cyrus.bookstore.model.Book;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void addBook(Book book){
        bookRepository.save(book);
    }
    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public void deleteBookById(Long id){
        bookRepository.deleteById(id);
    }
    public void updateBook(Long id, Book book){
        Optional<Book> oldBook = bookRepository.findById(id);
        if (oldBook.isPresent()) {
            Book newBook = new Book();
            newBook.setAuthor(book.getAuthor());
            newBook.setTitle(book.getTitle());
            newBook.setId(id);
        }
        
    }

    
}
