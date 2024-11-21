package com.foodorder.services;

import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Override
    public void sendWelcomeEmail(String email) {
        // Implement the logic to send a welcome email
        System.out.println("Sending welcome email to: " + email);
    }

    @Override
    public void sendEmail(String subject, String message) {
        // Implement sending an email with subject and message
        System.out.println("Sending email with subject: " + subject + " and message: " + message);
    }
}
