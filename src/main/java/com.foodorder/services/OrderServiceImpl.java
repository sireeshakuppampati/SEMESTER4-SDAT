package com.foodorder.services;

import com.foodorder.models.Order;
import com.foodorder.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Implement the method to place a new order
    @Override
    public Order placeOrder(Order order) {
        return orderRepository.save(order); // Save the order to the database
    }

    // Implement the method to fetch the order status by ID
    @Override
    public Order getOrderStatus(Long id) {
        return orderRepository.findById(id).orElse(null); // Return the order if found, else null
    }
}
