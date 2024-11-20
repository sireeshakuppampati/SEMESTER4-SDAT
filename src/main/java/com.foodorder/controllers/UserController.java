package com.foodorder.controllers;  // Adjust the package as necessary

import com.foodorder.models.User;
import com.foodorder.models.ErrorResponse;  // Import the ErrorResponse class
import com.foodorder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // GET endpoint to retrieve user by ID
    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            // Return custom error response with 404 status
            ErrorResponse error = new ErrorResponse("User not found with ID: " + id, 404);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }

    // POST endpoint to create a new user
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Save the new user to the database
        User savedUser = userRepository.save(user);

        // Return 201 Created status with the saved user in the response body
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
}
