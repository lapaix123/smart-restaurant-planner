package com.restaurant.smart_restaurant_planner.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OTPDTO {

    private Long id;
    private Long userId;
    private String otpCode;
    private LocalDateTime generatedTime;
    private LocalDateTime expirationTime;
    private boolean isUsed;
}
