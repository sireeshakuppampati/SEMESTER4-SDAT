package com.foodorder.services;

import com.foodorder.models.User;
import com.foodorder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long userId) {
        // Retrieve the user from the repository
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }

    @Override
    public User createUser(User user) {
        // Save the user to the repository
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userId, User updatedUserDetails) {
        // Fetch the user from the repository using the provided userId
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        // Update the fields of the existing user with the details from the provided user
        user.setName(updatedUserDetails.getName());
        user.setEmail(updatedUserDetails.getEmail());
        user.setPhoneNumber(updatedUserDetails.getPhoneNumber());

        // Save and return the updated user
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        // Find the user by ID
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        // Delete the user
        userRepository.delete(user);
    }
}
