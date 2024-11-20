package com.foodorder.controllers;

import com.foodorder.models.Order;
import com.foodorder.services.OrderService; // Inject the OrderService interface
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService; // Injecting the OrderService

    // Endpoint to place a new order
    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order); // Delegate the logic to the service layer
    }

    // Endpoint to get order status by ID
    @GetMapping("/{id}")
    public Order getOrderStatus(@PathVariable Long id) {
        Order order = orderService.getOrderStatus(id); // Delegate the logic to the service layer
        if (order == null) {
            throw new RuntimeException("Order not found with ID: " + id);
        }
        return order;
    }
}
