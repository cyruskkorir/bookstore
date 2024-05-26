package com.cyrus.bookstore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class DashboardController {


    @GetMapping("/home")
    public String getDashboard() {
        return "hello";
    }
    // @PostMapping("/home")
    // public String postMethodName(@RequestBody String entity) {
    //     return entity;
    // }
    
    
    
}
