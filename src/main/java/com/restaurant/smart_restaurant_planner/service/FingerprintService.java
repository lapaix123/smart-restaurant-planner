package com.restaurant.smart_restaurant_planner.service;

import com.restaurant.smart_restaurant_planner.dto.FingerprintDTO;

public interface FingerprintService {
    FingerprintDTO saveFingerprint(FingerprintDTO fingerprintDTO);
    FingerprintDTO getFingerprintByUserId(Long userId);
}
