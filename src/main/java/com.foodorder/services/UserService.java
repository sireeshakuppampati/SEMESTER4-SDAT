package com.foodorder.services;

import com.foodorder.models.User;

public interface UserService {
    User getUserById(Long userId);
    User createUser(User user);
    User updateUser(Long userId, User updatedUserDetails);
    void deleteUser(Long userId);
}
