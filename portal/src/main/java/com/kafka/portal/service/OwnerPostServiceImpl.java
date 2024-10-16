package com.kafka.portal.service;

import com.kafka.portal.client.CarPostStoreClient;
import com.kafka.portal.dto.OwnerPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService{

    @Autowired
    private CarPostStoreClient carPostStoreClient;

    @Override
    public void createOwnerCar(OwnerPostDTO ownerPostDTO) {

        carPostStoreClient.ownerPostsClient(ownerPostDTO);
    }
}
