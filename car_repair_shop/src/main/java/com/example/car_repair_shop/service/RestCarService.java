package com.example.car_repair_shop.service;


import com.example.car_repair_shop.web.RestCar;
import com.example.car_repair_shop.web.RestCarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestCarService {

    private final RestCarRepository restCarRepository;

    public RestCar save(RestCar restCar) {
        return restCarRepository.save(restCar);
    }

    public List<RestCar> findAll() {
        return restCarRepository.findAll();
    }

    public List<RestCar> findByBrand(String brand) {
        return restCarRepository.findByBrand(brand);
    }

    public RestCar findById(Long id) {
        return restCarRepository.findById(id).orElseThrow();
    }

    public void deleteById(Long id) {
        restCarRepository.deleteById(id);
    }

}
