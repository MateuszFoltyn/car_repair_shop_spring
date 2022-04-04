package com.example.car_repair_shop.repository;

import com.example.car_repair_shop.persistance.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findBySecondName (String secondName);

//    @Query(value = "select * from customer, car" + " join customer c on car.customer_id = c.id" + " where brand = ?1", nativeQuery = true)
//    List<Customer> findAllByCarsBand(String brand);



}
