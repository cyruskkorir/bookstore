package com.cyrus.bookstore.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyrus.bookstore.OrderRequest;
import com.cyrus.bookstore.model.Order;
import com.cyrus.bookstore.service.orderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    // Inject OrderService (not shown here)
    
    @PostMapping
    public Order createOrder(@RequestBody OrderRequest orderRequest) {
        // Process order details (e.g., calculate total price, save to database)
        return orderService.createOrder(orderRequest);
    }
    
    // Other endpoints for retrieving order history, etc.
}

