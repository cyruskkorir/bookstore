package com.cyrus.bookstore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DashboardController {
    @GetMapping("path")
    public String getHomePage(@RequestParam String param) {
        return "home";
    }
    
    
}
