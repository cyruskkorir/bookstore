package com.cyrus.bookstore.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cyrus.bookstore.model.Book;
import com.cyrus.bookstore.service.BookService;





@Controller
public class BookController {
    @Autowired
    private final BookService bookService;
    
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/add-book")
    public String postBook(Book book) {
        bookService.addBook(book);
        return "redirect:/books";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/add-book")
    public String showSaveBook(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }
    
    

    @GetMapping("/books")
    public String requestBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book-list";
    }

    @PutMapping("books/update/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody Book book) {
        bookService.updateBook(id, book);
    }

    @DeleteMapping("books/delete/{id}")
    public void deleteBookById(@PathVariable Long id){
        bookService.deleteBookById(id);
    }


    
}
