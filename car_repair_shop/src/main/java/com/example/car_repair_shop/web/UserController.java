package com.example.car_repair_shop.web;

import com.example.car_repair_shop.persistance.User;
import com.example.car_repair_shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

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

}
