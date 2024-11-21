package com.foodorder.services;

import com.foodorder.models.Order;

public interface OrderService {
    Order placeOrder(Order order);
    Order getOrderStatus(Long id);
}
