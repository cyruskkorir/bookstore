package com.cyrus.bookstore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
    @GetMapping("/login")
    public String getMethodName() {
        return "login";
    }
    
}
