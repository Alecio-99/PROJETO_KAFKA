package com.kafka.portal.service;

import com.kafka.portal.client.CarPostStoreClient;
import com.kafka.portal.dto.CarPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPostStoreServiceimpl implements CarPostStoreService {


    @Autowired
    private CarPostStoreClient carPostStoreClient;

    @Override
    public List<CarPostDTO> getCarForSales() {

        return carPostStoreClient.carForSalesClient();
    }


    @Override
    public void changeCarForSales(CarPostDTO carPostDTO, String id) {

        carPostStoreClient.changeCarForSaleClient(carPostDTO, id);
    }

    @Override
    public void removeCarForSales(String id) {

        carPostStoreClient.deleteCarForSaleClien(id);
    }
}
