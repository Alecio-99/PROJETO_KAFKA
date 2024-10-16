package com.kafka.portal.service;

import com.kafka.portal.dto.CarPostDTO;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CarPostStoreService {

    List<CarPostDTO> getCarForSales();

    void changeCarForSales(CarPostDTO carPostDTO, String id);

    void removeCarForSales(String id);
}
