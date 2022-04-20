package com.example.car_repair_shop.service;

import com.example.car_repair_shop.persistance.Car;
import com.example.car_repair_shop.persistance.User;
import com.example.car_repair_shop.repository.CarRepository;
import com.example.car_repair_shop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final PasswordEncoder passwordEncoder;

    public User save(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public List<User> findByBrand(String brand) {
        return carRepository.findByBrand(brand).stream()
                .map(Car::getUser)
                .collect(Collectors.toList());

//        return userRepository.findAllByCarBrand(brand);
    }

    public List<User> findBySecondName(String secondName) {
        return userRepository.findBySecondName(secondName);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }
}
