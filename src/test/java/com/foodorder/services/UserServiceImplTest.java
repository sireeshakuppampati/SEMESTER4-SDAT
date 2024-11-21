package com.foodorder.services;

import com.foodorder.models.User;
import com.foodorder.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User testUser;

    @BeforeEach
    public void setUp() {
        // Initialize mock objects
        MockitoAnnotations.openMocks(this);

        // Create a test user instance
        testUser = new User(1L, "John Doe", "john.doe@example.com", "1234567890");
    }

    @Test
    public void testCreateUser() {
        // Given
        when(userRepository.save(any(User.class))).thenReturn(testUser);

        // When
        User createdUser = userService.createUser(testUser);

        // Then
        assertNotNull(createdUser);
        assertEquals("John Doe", createdUser.getName());
        assertEquals("john.doe@example.com", createdUser.getEmail());
        assertEquals("1234567890", createdUser.getPhoneNumber());
    }

    @Test
    public void testGetUserById() {
        // Given
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(testUser));

        // When
        User foundUser = userService.getUserById(1L);

        // Then
        assertNotNull(foundUser);
        assertEquals("John Doe", foundUser.getName());
    }

    @Test
    public void testUpdateUser() {
        // Given
        User updatedUserDetails = new User(null, "Updated Name", "updated.email@example.com", "9876543210");
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(testUser));
        when(userRepository.save(any(User.class))).thenReturn(testUser);

        // When
        userService.updateUser(1L, updatedUserDetails);

        // Then
        assertEquals("Updated Name", testUser.getName());
        assertEquals("updated.email@example.com", testUser.getEmail());
        assertEquals("9876543210", testUser.getPhoneNumber());
    }

    @Test
    public void testDeleteUser() {
        // Given
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(testUser));

        // When
        userService.deleteUser(1L);

        // Then
        verify(userRepository, times(1)).delete(testUser);
    }
}
