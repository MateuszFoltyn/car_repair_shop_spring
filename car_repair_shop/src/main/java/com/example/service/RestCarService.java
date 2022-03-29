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

    public RestCar add(RestCar restCar) {
        return restCarRepository.add(restCar);
    }

    public List<RestCar> findAll() {
        return restCarRepository.findAll();
    }

    public List<RestCar> findByMark(String mark) {
        return restCarRepository.findByMark(mark);
    }

    public RestCar findById(Long id) {
        return restCarRepository.findById(id);
    }

    public boolean deleteById(Long id) {
        return restCarRepository.deleteById(id);
    }

}
