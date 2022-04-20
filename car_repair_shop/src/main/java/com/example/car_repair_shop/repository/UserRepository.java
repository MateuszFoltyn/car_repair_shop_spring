package com.example.car_repair_shop.repository;

import com.example.car_repair_shop.persistance.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findBySecondName (String secondName);
    Optional<User> findByUsername (String username);

//    @Query(value = "select * from customer, car" + " join customer c on car.customer_id = c.id" + " where brand = ?1", nativeQuery = true)
//    List<User> findAllByCarsBand(String brand);



}
