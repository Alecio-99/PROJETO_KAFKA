package com.store.car.service;

import com.store.car.dto.CarPostDTO;
import com.store.car.entity.CarPostEntity;
import com.store.car.repository.CarpostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarPostServiceImpl implements CarPostService{
    
    @Autowired
    private CarpostRepository carpostRepository;
    
    @Override
    public void newPostDetails(CarPostDTO carPostDTO) {
        CarPostEntity carPostEntity = mapCarEntityToDTO(carPostDTO);
        carpostRepository.save(carPostEntity);

    }

    @Override
    public List<CarPostDTO> getCarSales() {
       List<CarPostDTO> listCarsSales = new ArrayList<>();
        carpostRepository.findAll().forEach(item->{
            listCarsSales.add(mapCarEntityToDTO(item));
        });
        return listCarsSales;
    }

    @Override
    public void changeCarSale(CarPostDTO carPostDTO, Long postId) {

        carpostRepository.findById(postId).ifPresentOrElse(item->{
            item.setDescription(carPostDTO.getDescription());
            item.setContact(carPostDTO.getContact());
            item.setPrice(carPostDTO.getPrice());
            item.setBrand(carPostDTO.getBrand());
            item.setEngineVersion(carPostDTO.getEngineVersion());
            item.setModel(carPostDTO.getModel());

            carpostRepository.save(item);
        }, ()->{
            throw new NoSuchElementException();
        });

    }

    @Override
    public void removeCarSale(Long postId) {
      carpostRepository.deleteById(postId);
    }


    

    private CarPostDTO mapCarEntityToDTO(CarPostEntity carPostEntity){
        
        return CarPostDTO.builder()
                .brand(carPostEntity.getBrand())
                .city(carPostEntity.getCity())
                .model(carPostEntity.getModel())
                .description(carPostEntity.getDescription())
                .engineVersion(carPostEntity.getEngineVersion())
                .createdDate(carPostEntity.getCreatedDate())
                .ownerName(carPostEntity.getOwnerName())
                .price(carPostEntity.getPrice()).build();
                
    }


}
