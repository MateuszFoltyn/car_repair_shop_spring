package com.example.car_repair_shop.repository;


import com.example.car_repair_shop.persistance.Car;
import com.example.car_repair_shop.persistance.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByBrand(String brand);
    List<Car> findByCustomer(User user);


}
