package com.example.car_repair_shop.repository;


import com.example.car_repair_shop.persistance.Car;
import com.example.car_repair_shop.persistance.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByBrand(String brand);
    List<Car> findByCustomer(Customer customer);












//
//    private static Long idSequence = 1L;
//    private final List<Car> restCarList = new ArrayList<>();
//
//    public Car add(Car restCar) {
//        restCar.setId(idSequence++);
//        return restCar;
//    }
//
//    public List<Car> findAll() {
//        return new ArrayList<>(restCarList);
//    }
//
//    public List<Car> findByMark(String mark) {
//        return restCarList.stream()
//                .filter(t -> t.getBrand().equals(mark))
//                .collect(Collectors.toList());
//    }
//
//    public Car findById(Long id) {
//        return restCarList.stream()
//                .filter(t -> t.getId() == id)
//                .findFirst().orElseThrow(RuntimeException::new);
//    }
//
//    public boolean deleteById(Long id) {
//        restCarList.remove(findById(id));
//        return true;
//    }


}
