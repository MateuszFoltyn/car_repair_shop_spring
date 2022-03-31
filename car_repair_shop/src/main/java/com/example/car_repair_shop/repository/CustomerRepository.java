package com.example.car_repair_shop.repository;

import com.example.car_repair_shop.persistance.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
