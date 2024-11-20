package com.foodorder.controllers;

import com.foodorder.models.Restaurant;
import com.foodorder.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepo;
    // some more updates
    // Get all restaurants
    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepo.findAll();
    }

    // Create a new restaurant
    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        try {
            // Save the restaurant and return a response with status CREATED
            Restaurant savedRestaurant = restaurantRepo.save(restaurant);
            return new ResponseEntity<>(savedRestaurant, HttpStatus.CREATED);
        } catch (Exception e) {
            // Return an internal server error if any exception occurs
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get a restaurant by ID
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {
        Optional<Restaurant> restaurantOpt = restaurantRepo.findById(id);
        if (restaurantOpt.isPresent()) {
            return new ResponseEntity<>(restaurantOpt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
