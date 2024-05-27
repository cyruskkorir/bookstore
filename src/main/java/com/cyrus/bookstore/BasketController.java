package com.cyrus.bookstore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BasketController {
    @GetMapping("/book/{id}")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    @GetMapping("/basket")
    public String getBasket() {
        return "books available";
    }
    
    
    
}
