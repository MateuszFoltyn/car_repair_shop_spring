package com.example.car_repair_shop.web;

import com.example.car_repair_shop.dto.UserDTO;
import com.example.car_repair_shop.dto.UserMapper;
import com.example.car_repair_shop.persistance.User;
import com.example.car_repair_shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;


    @GetMapping("/{secondName}")
    public ResponseEntity<List<User>> getSecondName(@PathVariable String secondName) {
        return ResponseEntity.ok(userService.findBySecondName(secondName));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getId(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/cars/{brand}")
    public ResponseEntity<List<User>> findByBrand(@PathVariable String brand) {
        return ResponseEntity.ok(userService.findByBrand(brand));
    }

    @PostMapping
    public ResponseEntity<User> save(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/usersdto")
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(userService.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList()));
    }
}
