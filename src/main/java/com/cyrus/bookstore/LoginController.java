package com.cyrus.bookstore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
    @GetMapping("/home")
    public String getMethodName() {
        return "home";
    }
    
}
