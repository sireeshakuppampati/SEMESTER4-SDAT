package com.foodorder.services;

import com.foodorder.models.Restaurant;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> getAllRestaurants();

    Restaurant getRestaurantById(Long id);

    Restaurant createRestaurant(Restaurant restaurant);

    Restaurant updateRestaurant(Long id, Restaurant updatedRestaurant);

    void deleteRestaurant(Long id);

    // Ensure this method exists in the interface
    Restaurant addRestaurant(Restaurant restaurant);
}
