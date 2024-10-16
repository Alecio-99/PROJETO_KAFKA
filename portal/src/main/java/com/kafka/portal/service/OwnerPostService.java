package com.kafka.portal.service;

import com.kafka.portal.dto.OwnerPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {
    void createOwnerCar(OwnerPostDTO ownerPostDTO);
}
