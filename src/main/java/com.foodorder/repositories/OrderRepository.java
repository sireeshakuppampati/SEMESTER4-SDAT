package com.foodorder.repositories;

import com.foodorder.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // Custom queries or methods can be defined here
}
