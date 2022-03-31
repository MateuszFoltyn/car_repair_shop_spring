package com.example.car_repair_shop.service;


import com.example.car_repair_shop.persistance.Car;
import com.example.car_repair_shop.persistance.Customer;
import com.example.car_repair_shop.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository restCarRepository;

    public Car save(Car car) {
        return restCarRepository.save(car);
    }

    public List<Car> findAll() {
        return restCarRepository.findAll();
    }

    public List<Car> findByBrand(String brand) {
        return restCarRepository.findByBrand(brand);
    }

    public Car findById(Long id) {
        return restCarRepository.findById(id).orElseThrow();
    }
    public List<Car> findByCustomer(Customer customer) {
        return restCarRepository.findByCustomer(customer);
    }


    public void deleteById(Long id) {
        restCarRepository.deleteById(id);
    }

}
