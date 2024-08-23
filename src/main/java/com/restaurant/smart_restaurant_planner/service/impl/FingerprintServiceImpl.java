package com.restaurant.smart_restaurant_planner.service.impl;

import com.restaurant.smart_restaurant_planner.dto.FingerprintDTO;
import com.restaurant.smart_restaurant_planner.model.Fingerprint;
import com.restaurant.smart_restaurant_planner.model.User;
import com.restaurant.smart_restaurant_planner.repository.FingerprintRepository;
import com.restaurant.smart_restaurant_planner.repository.UserRepository;
import com.restaurant.smart_restaurant_planner.service.FingerprintService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FingerprintServiceImpl implements FingerprintService {

    @Autowired
    private FingerprintRepository fingerprintRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FingerprintDTO saveFingerprint(FingerprintDTO fingerprintDTO) {
        Fingerprint fingerprint = modelMapper.map(fingerprintDTO, Fingerprint.class);
        Fingerprint savedFingerprint = fingerprintRepository.save(fingerprint);
        return modelMapper.map(savedFingerprint, FingerprintDTO.class);
    }

    @Override
    public FingerprintDTO getFingerprintByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Fingerprint fingerprint = user.getFingerprint();
        if (fingerprint == null) {
            throw new RuntimeException("Fingerprint data not found for this user");
        }

        return modelMapper.map(fingerprint, FingerprintDTO.class);
    }
}
