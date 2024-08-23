package com.restaurant.smart_restaurant_planner.controller;

import com.restaurant.smart_restaurant_planner.dto.OTPDTO;
import com.restaurant.smart_restaurant_planner.service.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/otp")
public class OTPController {

    @Autowired
    private OTPService otpService;

    @PostMapping("/generate/{userId}")
    public ResponseEntity<OTPDTO> generateOTP(@PathVariable Long userId) {
        OTPDTO otpDTO = otpService.generateOTPForUser(userId);
        return ResponseEntity.ok(otpDTO);
    }

    @PostMapping("/validate")
    public ResponseEntity<Boolean> validateOTP(@RequestParam Long userId, @RequestParam String otpCode) {
        boolean isValid = otpService.validateOTP(userId, otpCode);
        return ResponseEntity.ok(isValid);
    }
}
