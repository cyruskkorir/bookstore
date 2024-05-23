package com.cyrus.bookstore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class DashboardController {


    @GetMapping("/dash")
    public String getDashboard(@RequestParam String param) {
        return "dashboard";
    }
    @PostMapping("/dash")
    public String postMethodName(@RequestBody String entity) {
        return entity;
    }
    
    
    
}
