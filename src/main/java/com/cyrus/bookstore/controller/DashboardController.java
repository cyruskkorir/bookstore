package com.cyrus.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class DashboardController {


    @GetMapping("/dashboard")
    public String getDashboard() {
        return "dashboard";
    }
    @PostMapping("/home")
    public String postMethodName(@RequestBody String entity) {
        return entity;
    }
    
    
    
}
