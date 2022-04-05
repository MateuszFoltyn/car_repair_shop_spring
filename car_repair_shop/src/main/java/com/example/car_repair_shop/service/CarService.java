package com.example.car_repair_shop.service;


import com.example.car_repair_shop.persistance.Car;
import com.example.car_repair_shop.persistance.Customer;
import com.example.car_repair_shop.repository.CarRepository;
import com.example.car_repair_shop.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CustomerService customerService;

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public List<Car> findByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }

    public Car findById(Long id) {
        return carRepository.findById(id).orElseThrow();
    }

    public List<Car> findByCustomerId(Long customerId) {
        return carRepository.findByCustomer(customerService.findById(customerId));
    }

    public Car sell(Long carId, Long customerId) {
        Car car = findById(carId);
        Customer customer = customerService.findById(customerId);
        car.setCustomer(customer);
        return save(car);
    }

    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }
}
