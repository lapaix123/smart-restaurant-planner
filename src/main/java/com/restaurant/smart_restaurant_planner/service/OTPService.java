package com.restaurant.smart_restaurant_planner.service;

import com.restaurant.smart_restaurant_planner.dto.OTPDTO;

public interface OTPService {
    OTPDTO generateOTPForUser(Long userId);
    boolean validateOTP(Long userId, String otpCode);
}
