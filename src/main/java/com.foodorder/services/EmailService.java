package com.foodorder.services;

public interface EmailService {
    void sendWelcomeEmail(String email);  // Existing method
    void sendEmail(String subject, String message);  // New method
}
