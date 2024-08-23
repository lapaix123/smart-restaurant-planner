package com.restaurant.smart_restaurant_planner.service;

public interface EmailService {
    /**
     * Sends a simple email with the provided subject and message to the specified email address.
     *
     * @param toEmail the recipient's email address
     * @param subject the subject of the email
     * @param message the message body of the email
     */
    void sendSimpleEmail(String toEmail, String subject, String message);

    /**
     * Sends an OTP email for email confirmation.
     *
     * @param toEmail the recipient's email address
     * @param otp the generated OTP code
     */
    void sendOTPEmail(String toEmail, String otp);
}
