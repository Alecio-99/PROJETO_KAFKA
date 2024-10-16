package com.kafka.portal.controller;

import com.kafka.portal.dto.CarPostDTO;
import com.kafka.portal.message.KafkaProducerMessage;
import com.kafka.portal.service.CarPostStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarPostController {

    @Autowired
    private CarPostStoreService carPostStoreService;

    @Autowired
    private KafkaProducerMessage kafkaProducerMessage;

    @PostMapping("/post")
    public ResponseEntity postCarForSale(@RequestBody CarPostDTO carPostDTO){
        kafkaProducerMessage.sendMessage(carPostDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<CarPostDTO>> getCarSales(){
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostStoreService.getCarForSales());
    }
    @PutMapping("/{id}")
    public ResponseEntity changeCarSales(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") String id){
        carPostStoreService.changeCarForSales(carPostDTO,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarForSale(@PathVariable("id") String id){
        carPostStoreService.removeCarForSales(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
