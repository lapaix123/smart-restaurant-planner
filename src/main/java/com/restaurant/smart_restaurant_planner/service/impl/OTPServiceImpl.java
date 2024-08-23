package com.restaurant.smart_restaurant_planner.service.impl;

import com.restaurant.smart_restaurant_planner.dto.OTPDTO;
import com.restaurant.smart_restaurant_planner.model.OTP;
import com.restaurant.smart_restaurant_planner.model.User;
import com.restaurant.smart_restaurant_planner.repository.OTPRepository;
import com.restaurant.smart_restaurant_planner.repository.UserRepository;
import com.restaurant.smart_restaurant_planner.service.OTPService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class OTPServiceImpl implements OTPService {

    @Autowired
    private OTPRepository otpRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OTPDTO generateOTPForUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String otpCode = String.valueOf(new Random().nextInt(9000) + 1000); // Generate a 4-digit OTP

        OTP otp = new OTP();
        otp.setUser(user);
        otp.setOtpCode(otpCode);
        otp.setGeneratedTime(LocalDateTime.now());
        otp.setExpirationTime(LocalDateTime.now().plusMinutes(5)); // OTP valid for 5 minutes
        otp.setUsed(false);

        OTP savedOTP = otpRepository.save(otp);
        return modelMapper.map(savedOTP, OTPDTO.class);
    }

    @Override
    public boolean validateOTP(Long userId, String otpCode) {
        OTP otp = otpRepository.findByUserIdAndIsUsedFalse(userId)
                .orElseThrow(() -> new RuntimeException("OTP not found or already used"));

        if (otp.getExpirationTime().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("OTP has expired");
        }

        if (otp.getOtpCode().equals(otpCode)) {
            otp.setUsed(true); // Mark OTP as used after successful validation
            otpRepository.save(otp);
            return true;
        }

        return false;
    }
}
