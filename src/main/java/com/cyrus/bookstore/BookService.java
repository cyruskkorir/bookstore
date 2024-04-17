package com.cyrus.bookstore;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

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

    
}
