package com.foodorder.repositories;

import com.foodorder.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // Custom queries and methods are be defined here
}
