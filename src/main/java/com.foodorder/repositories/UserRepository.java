package com.foodorder.repositories;


import com.foodorder.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Additional query methods, if needed
}
