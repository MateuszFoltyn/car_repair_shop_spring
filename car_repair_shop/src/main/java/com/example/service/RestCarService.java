package com.example.service;


import com.example.web.RestCar;
import com.example.web.RestCarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
